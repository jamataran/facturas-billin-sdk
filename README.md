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
│   │   └── README.md
│   └── php-sdk/            # SDK para PHP
│       ├── composer.json
│       ├── openapi-generator-config.yaml
│       └── README.md
├── openapi-spec/
│   ├── swagger.json        # Especificación OpenAPI (PLACEHOLDER)
│   └── README.md
├── package.json            # Configuración del monorepo
├── turbo.json              # Configuración de Turborepo
└── README.md
```

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
