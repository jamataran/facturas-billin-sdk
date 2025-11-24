# Facturas Billin SDK

Repositorio **NO OFICIAL** con SDKs para consumir la API REST de [Facturas Billin](https://www.facturasbillin.net/) en diferentes lenguajes de programación.

Este proyecto utiliza [Turborepo](https://turbo.build/) para gestionar múltiples paquetes de SDKs generados automáticamente a partir de la especificación OpenAPI/Swagger de la API de Facturas Billin.

## 📦 Paquetes Disponibles

- **[Java/Maven SDK](./packages/java-sdk)** - SDK para aplicaciones Java
- **[PHP SDK](./packages/php-sdk)** - SDK para aplicaciones PHP

## 🚀 Inicio Rápido

### Requisitos Previos

- Node.js 18.0 o superior
- npm 10.0 o superior
- Para Java SDK: Java 11+ y Maven 3.6+
- Para PHP SDK: PHP 7.4+ y Composer

### Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/jamataran/facturas-billin-sdk.git
cd facturas-billin-sdk
```

2. Instala las dependencias:
```bash
npm install
```

3. **IMPORTANTE**: Actualiza la especificación OpenAPI en `openapi-spec/swagger.json` con el archivo oficial de Facturas Billin.

4. Genera los SDKs:
```bash
npm run generate
```

5. Compila todos los paquetes:
```bash
npm run build
```

## 🔧 Comandos Disponibles

Desde la raíz del proyecto (usando Turborepo):

```bash
# Genera todos los SDKs a partir de la especificación OpenAPI
npm run generate

# Compila todos los paquetes
npm run build

# Ejecuta los tests de todos los paquetes
npm run test

# Limpia los archivos generados y artefactos de compilación
npm run clean
```

### Ejecutar comandos para un solo paquete

Para ejecutar comandos específicos solo para el Java SDK:

```bash
# Generar solo el Java SDK
npm run generate -- --filter=@facturas-billin-sdk/java

# Compilar solo el Java SDK
npm run build -- --filter=@facturas-billin-sdk/java

# Ejecutar tests solo del Java SDK
npm run test -- --filter=@facturas-billin-sdk/java

# Limpiar solo el Java SDK
npm run clean -- --filter=@facturas-billin-sdk/java
```

También puedes ejecutar comandos directamente desde el directorio del paquete:

```bash
cd packages/java-sdk
npm run generate  # Genera el código desde OpenAPI spec
npm run build     # Compila el SDK (mvn clean package)
npm run test      # Ejecuta los tests (mvn test)
npm run clean     # Limpia archivos generados (mvn clean)
```

### Configuración de Variables de Entorno para Tests

Los tests de integración requieren una API key válida de Billin. Para configurarla:

1. Copia el archivo `.env.example` a `.env.local`:
```bash
cp .env.example .env.local
```

2. Edita `.env.local` y agrega tu API key:
```
BILLIN_API_KEY=tu-clave-api-aqui
```

**Nota**: El archivo `.env.local` está en `.gitignore` y no se subirá al repositorio.

## 📖 Uso de los SDKs

### Java SDK

```java
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.api.*;
import net.facturasbillin.sdk.model.*;

public class Example {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKey("YOUR_API_KEY");
        
        // Usa las APIs generadas según la especificación
        // DefaultApi api = new DefaultApi(client);
    }
}
```

Ver [documentación completa del Java SDK](./packages/java-sdk/README.md)

### PHP SDK

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

use FacturasBillin\SDK\Configuration;
use FacturasBillin\SDK\Api\DefaultApi;

$config = Configuration::getDefaultConfiguration()
    ->setApiKey('Authorization', 'YOUR_API_KEY');

$apiInstance = new DefaultApi(
    new GuzzleHttp\Client(),
    $config
);

// Usa las APIs generadas según la especificación
?>
```

Ver [documentación completa del PHP SDK](./packages/php-sdk/README.md)

## 🔑 Especificación OpenAPI

La especificación OpenAPI/Swagger debe ubicarse en `openapi-spec/swagger.json`. Este archivo es la fuente de verdad para generar todos los SDKs.

**Nota**: El archivo actual es un placeholder. Debes reemplazarlo con la especificación oficial de Facturas Billin.

Ver [documentación de la especificación](./openapi-spec/README.md)

## 🏗️ Estructura del Proyecto

```
facturas-billin-sdk/
├── packages/
│   ├── java-sdk/           # SDK para Java/Maven
│   │   ├── pom.xml
│   │   ├── openapi-generator-config.yaml
│   │   ├── package.json
│   │   └── README.md
│   └── php-sdk/            # SDK para PHP
│       ├── composer.json
│       ├── openapi-generator-config.yaml
│       ├── package.json
│       └── README.md
├── openapi-spec/
│   ├── swagger.json        # Especificación OpenAPI (PLACEHOLDER)
│   └── README.md
├── .github/
│   └── workflows/
│       └── ci.yml          # GitHub Actions CI/CD
├── package.json            # Configuración del monorepo
├── turbo.json              # Configuración de Turborepo
├── .env.example            # Ejemplo de configuración de entorno
└── README.md
```

## 🏗️ Arquitectura y Flujo de Ejecución

El proyecto utiliza una arquitectura en capas para la gestión y ejecución de tareas:

```
TurboRepo → Node/npm → Maven → Tests
```

### Cómo funciona:

1. **TurboRepo**: Orquesta y cachea las tareas del monorepo, optimizando la ejecución paralela
2. **Node/npm**: Proporciona gestión de workspaces y scripts multiplataforma
3. **Maven**: Maneja la generación de código desde OpenAPI, compilación y testing del Java SDK
4. **Tests**: JUnit 5 para tests unitarios e integración

Este flujo permite:
- ✅ Ejecución local sin scripts de shell
- ✅ Integración con CI/CD (GitHub Actions)
- ✅ Cacheo inteligente de builds
- ✅ Ejecución paralela de tests en múltiples SDKs
- ✅ Multiplataforma (Windows, Linux, macOS)

## 🛠️ Desarrollo

### Agregar un Nuevo Lenguaje

1. Crea un nuevo paquete en `packages/<language>-sdk/`
2. Añade un `package.json` con los scripts de generación, build y test
3. Configura OpenAPI Generator para el lenguaje objetivo
4. Actualiza la documentación

### Regenerar los SDKs

Después de actualizar la especificación OpenAPI:

```bash
npm run clean
npm run generate
npm run build
npm run test
```

## 📝 Licencia

Este proyecto es **NO OFICIAL** y se distribuye bajo la Licencia Apache 2.0. Ver el archivo [LICENSE](./LICENSE) para más detalles.

## ⚠️ Disclaimer

Este es un proyecto **no oficial** y no está afiliado, asociado, autorizado, respaldado por, ni de ninguna manera oficialmente conectado con Facturas Billin o cualquiera de sus subsidiarias o afiliadas.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/amazing-feature`)
3. Commit tus cambios (`git commit -m 'Add amazing feature'`)
4. Push a la rama (`git push origin feature/amazing-feature`)
5. Abre un Pull Request

## 📞 Soporte

Para soporte oficial de la API de Facturas Billin, visita [https://www.facturasbillin.net/](https://www.facturasbillin.net/)

Para issues relacionados con este SDK, por favor abre un issue en este repositorio.
