# Guía de Contribución

¡Gracias por tu interés en contribuir al proyecto Facturas Billin SDK!

## 🚀 Comenzando

1. Fork el repositorio
2. Clona tu fork localmente
3. Crea una rama para tu contribución
4. Realiza tus cambios
5. Ejecuta los tests
6. Envía un Pull Request

## 📋 Requisitos

- Node.js 18.0+
- npm 10.0+
- Para desarrollo en Java SDK: Java 11+ y Maven 3.6+
- Para desarrollo en PHP SDK: PHP 7.4+ y Composer

## 🏗️ Configuración del Entorno de Desarrollo

```bash
# Clona el repositorio
git clone https://github.com/YOUR_USERNAME/facturas-billin-sdk.git
cd facturas-billin-sdk

# Instala las dependencias
npm install

# Genera los SDKs (requiere la especificación OpenAPI válida)
npm run generate

# Compila los paquetes
npm run build
```

## 🧰 Monorepo con Turborepo

El repositorio es un monorepo npm + [Turborepo](https://turbo.build/repo) con la
siguiente estructura:

```
facturas-billin-sdk/
├── openapi-spec/swagger.json     # Fuente única de verdad de la API
├── packages/
│   ├── java-sdk/                 # SDK Java (Maven)
│   └── php-sdk/                  # SDK PHP (Composer)
├── turbo.json                    # Pipeline de Turborepo
└── package.json                  # Workspaces npm
```

### Pipeline de Turborepo

`turbo.json` define cuatro tareas que se ejecutan por paquete:

| Tarea | Depende de | Inputs | Outputs cacheados |
|-------|------------|--------|-------------------|
| `generate` | – | `openapi-spec/**` (global), `openapi-generator-config.yaml`, `openapitools.json`, `generate.sh` | `src/**`, `lib/**`, `docs/**`, `api/**`, `.openapi-generator/**` |
| `build` | `generate`, `^build` | – | `dist/**`, `target/**`, `vendor/**` |
| `test` | `build` | – | reportes (no cacheable) |
| `clean` | – | – | – (no cacheable) |

`openapi-spec/**` está declarado como `globalDependencies`, así que cualquier cambio
en el swagger invalida la caché de `generate` y `build` en todos los paquetes a la vez.

### Comandos típicos

| Quiero... | Comando |
|-----------|---------|
| Regenerar Java desde el swagger | `npm run generate:java` |
| Regenerar PHP desde el swagger | `npm run generate:php` |
| Regenerar todos los SDKs en paralelo | `npm run generate:all` |
| Compilar todos los paquetes | `npm run build` |
| Compilar sólo Java | `npm run build:java` |
| Forzar regeneración (ignorar caché) | `npx turbo run generate --force` |
| Ver el grafo de dependencias | `npx turbo run build --graph` |
| Limpiar artefactos | `npm run clean` |

> Si una tarea no aparece, ejecútala directamente con `npx turbo run <tarea> --filter=@facturas-billin-sdk/java`.

## 🔧 Flujo de Trabajo

### 1. Actualizar la Especificación OpenAPI

Si necesitas actualizar la especificación de la API:

1. Sustituye `openapi-spec/swagger.json` por la nueva versión.
2. Regenera los SDKs: `npm run generate` (turbo invalidará la caché automáticamente).
3. Compila para detectar cambios incompatibles: `npm run build`.
4. Si los DTOs cambian de forma o se renombran, **actualiza los tests de
   integración** (`packages/java-sdk/src/test/java/...`) — el generador no los
   ajusta por ti.
5. Ejecuta los tests: `npm run test`.
6. Decide qué bump de versión corresponde según [Semver](https://semver.org/lang/es/):
   - **MAJOR** si hay cambios incompatibles en DTOs, firmas de método, o enums cerrados.
   - **MINOR** si sólo se añaden endpoints/campos opcionales.
   - **PATCH** si son correcciones de descripciones, ejemplos o cambios cosméticos.
7. Actualiza la versión en `pom.xml`, `openapi-generator-config.yaml`,
   `package.json` y los ejemplos del README de cada paquete que cambie.

### 2. Agregar un Nuevo Lenguaje

Para agregar soporte para un nuevo lenguaje:

1. Crea un directorio en `packages/<language>-sdk/`
2. Añade los archivos de configuración necesarios:
   - `package.json` con scripts `generate`, `build`, `test`, `clean` y nombre `@facturas-billin-sdk/<lang>`
   - `openapi-generator-config.yaml` con la configuración del generador
   - `README.md` con documentación del SDK
3. Configura las dependencias específicas del lenguaje
4. Asegúrate de que los nombres de tarea coincidan con `turbo.json` (`generate`, `build`, `test`, `clean`)
5. Actualiza el README principal y añade el nuevo paquete a la tabla de versiones

### 3. Mejorar la Configuración del Generador

Las configuraciones de OpenAPI Generator están en:
- Java: `packages/java-sdk/openapi-generator-config.yaml`
- PHP: `packages/php-sdk/openapi-generator-config.yaml`

Consulta la [documentación de OpenAPI Generator](https://openapi-generator.tech/docs/generators/) para opciones disponibles.

## ✅ Checklist Antes de Enviar un PR

- [ ] El código compila sin errores
- [ ] Los tests existentes pasan
- [ ] Has añadido tests para nuevas funcionalidades (si aplica)
- [ ] La documentación está actualizada
- [ ] Has seguido las convenciones de código del proyecto
- [ ] El commit message es descriptivo

## 📝 Estilo de Código

### Commits

Usa mensajes de commit descriptivos en español o inglés:

```
feat: Agregar soporte para Python SDK
fix: Corregir configuración de Maven
docs: Actualizar documentación de instalación
refactor: Reorganizar estructura de paquetes
```

### Código Generado

- No modifiques directamente el código generado en `src/` o `lib/`
- Los cambios deben hacerse en:
  - La especificación OpenAPI (`openapi-spec/swagger.json`)
  - Los archivos de configuración del generador
  - Las plantillas personalizadas (si aplica)

## 🧪 Tests

```bash
# Ejecutar todos los tests
npm run test

# Tests específicos por paquete
cd packages/java-sdk && npm run test
cd packages/php-sdk && npm run test
```

## 📚 Recursos

- [OpenAPI Generator Documentation](https://openapi-generator.tech/)
- [Turborepo Documentation](https://turbo.build/repo/docs)
- [Facturas Billin API](https://www.facturasbillin.net/)

## 🤔 ¿Necesitas Ayuda?

- Abre un issue para discutir cambios grandes antes de trabajar en ellos
- Revisa issues existentes para ver si alguien ya está trabajando en algo similar
- Únete a las discusiones en los PRs existentes

## 📜 Código de Conducta

Este proyecto adhiere a un código de conducta de colaboración respetuosa. Al participar, se espera que mantengas un ambiente acogedor y profesional.

## 📄 Licencia

Al contribuir, aceptas que tus contribuciones se licenciarán bajo la misma licencia Apache 2.0 del proyecto.
