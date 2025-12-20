# 📦 Distribución de Paquetes - Guía Completa

Este documento responde las preguntas sobre distribución y publicación de los SDKs.

## 1️⃣ ¿bootstrap.php hay que subirlo al repo?

**SÍ, DEFINITIVAMENTE.** 

El archivo `bootstrap.php` es **esencial** para que el SDK funcione correctamente, especialmente para:
- Cargar las variables de entorno desde `.env.local`
- Autocargar las clases del SDK mediante Composer
- Ejecutar los tests correctamente en PHPUnit

### Lo que se sube y lo que NO:

✅ **SE SUBE** `bootstrap.php`
- Es parte de la configuración del SDK
- Es necesario para los tests y aplicaciones finales
- No contiene datos sensibles

❌ **NO SE SUBE** `.env.local`
- Contiene credenciales reales (Client ID y Secret)
- Está en `.gitignore` para proteger datos sensibles
- Cada desarrollador crea su propia copia desde `.env.example`

### Estructura correcta en el repositorio:

```
php-sdk/
├── bootstrap.php                ✅ SUBE (parte del SDK)
├── phpunit.xml                  ✅ SUBE (configuración de tests)
├── .env.example                 ✅ SUBE (plantilla de credenciales)
├── .env.local                   ❌ NO SUBE (credenciales reales)
├── .gitignore                   ✅ SUBE (especifica qué no subir)
├── composer.json                ✅ SUBE
├── composer.lock                ❌ NO SUBE (generado por Composer)
└── vendor/                       ❌ NO SUBE (generado por Composer)
```

---

## 2️⃣ Actualizar el README para consumir el SDK

✅ **YA HECHO** - Actualicé los README con:

### A. README del PHP SDK (`packages/php-sdk/README.md`)

- ✅ **Inicio Rápido**: Ejemplo simple de crear una factura
- ✅ **Tres opciones de autenticación**:
  1. Con token de acceso
  2. Con Client Credentials (OAuth2)
  3. Configuración manual avanzada
- ✅ **Ejemplos prácticos** de operaciones comunes:
  - Crear facturas
  - Listar facturas
  - Crear contactos
  - Crear gastos
- ✅ **Guía de configuración en PHP Storm**
- ✅ **Instrucciones para ejecutar tests**
- ✅ **Información sobre publicación en Packagist**

### B. README principal (`README.md`)

- ✅ **Ejemplos de instalación y uso** para ambos SDKs
- ✅ **Información sobre dónde se distribuyen**:
  - Java: Maven Central
  - PHP: Packagist
- ✅ **Flujo completo de actualización y publicación**

---

## 3️⃣ ¿A dónde se subirá este framework?

### Java SDK 🚀 → **Maven Central Repository**

Similar a cómo subiste a Maven, el SDK se publica en Maven Central.

**Instalación por desarrolladores:**
```xml
<dependency>
    <groupId>net.facturasbillin</groupId>
    <artifactId>facturas-billin-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Búsqueda:** https://mvnrepository.com/search?q=facturas-billin

### PHP SDK 🚀 → **Packagist.org**

Es el equivalente de Maven Central pero para PHP. Cualquier desarrollador puede instalar con Composer.

**Instalación por desarrolladores:**
```bash
composer require facturas-billin/php-sdk
```

**Búsqueda:** https://packagist.org/search/?q=facturas-billin

---

## 🔄 Flujo de Publicación

### Primera vez (Setup inicial):

#### Para Maven Central (Java):
1. Registrarse en [Sonatype JIRA](https://issues.sonatype.org/browse/OSSRH)
2. Crear ticket para nuevo proyecto `net.facturasbillin`
3. Configurar GPG signing en pom.xml
4. Configurar credenciales en settings.xml
5. Una vez aprobado, ejecutar: `mvn clean deploy`

#### Para Packagist (PHP):
1. Registrarse en [Packagist.org](https://packagist.org/register/)
2. Ir a [Submit Package](https://packagist.org/packages/submit)
3. Ingresar: `https://github.com/jamataran/facturas-billin-sdk`
4. **¡Automático!** - Se actualiza automáticamente con cada push a GitHub

### Actualizaciones posteriores:

1. **Actualizar especificación OpenAPI**
   ```bash
   # Reemplaza openapi-spec/swagger.json
   ```

2. **Regenerar SDKs**
   ```bash
   npm run generate
   ```

3. **Compilar y testear**
   ```bash
   npm run build
   npm run test
   ```

4. **Actualizar versiones**
   - `packages/java-sdk/pom.xml`: Cambiar `<version>1.x.x</version>`
   - `packages/php-sdk/composer.json`: Cambiar `"version": "1.x.x"`

5. **Crear release en GitHub**
   ```bash
   git add .
   git commit -m "Release v1.x.x: descripción"
   git tag v1.x.x
   git push origin main --tags
   ```

6. **Publicación automática**
   - ✅ PHP: Packagist lo detecta automáticamente
   - ✅ Java: Maven Central lo detecta automáticamente (si está bien configurado)

---

## 📋 Checklist para Publicación

### Antes de publicar:

- [ ] Especificación OpenAPI actualizada
- [ ] SDKs regenerados
- [ ] Tests pasando (`npm run test`)
- [ ] README actualizado en ambos paquetes
- [ ] Versión actualizada en pom.xml y composer.json
- [ ] Changelog actualizado
- [ ] .env.example con variables de entorno correctas
- [ ] .gitignore protege credenciales

### Publicación:

- [ ] Commit con mensaje descriptivo
- [ ] Tag de versión creado (`v1.x.x`)
- [ ] Push a main y tags: `git push origin main --tags`
- [ ] Verificar en Maven Central (puede tomar horas)
- [ ] Verificar en Packagist (debería ser inmediato)

---

## 🎯 Resumen

| Pregunta | Respuesta |
|----------|-----------|
| ¿bootstrap.php al repo? | ✅ **SÍ**, es esencial. Pero `.env.local` **NO** |
| ¿README actualizado? | ✅ **SÍ**, con ejemplos prácticos y guías |
| ¿Dónde se suben? | ✅ **Java**: Maven Central, **PHP**: Packagist |
| ¿Cómo publican? | ✅ Automáticamente con GitHub tags/releases |
| ¿Puedo usarlo como Maven? | ✅ **SÍ**: `composer require facturas-billin/php-sdk` |

Los SDKs están listos para ser publicados. Solo necesitas:
1. Hacer el setup inicial de credenciales (una sola vez)
2. Crear un tag en GitHub
3. ¡Los paquetes se publicarán automáticamente! 🚀

