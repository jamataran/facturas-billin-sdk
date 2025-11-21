# Facturas Billin PHP SDK

SDK no oficial en PHP para consumir la API REST de [Facturas Billin](https://www.facturasbillin.net/).

## Requisitos

- PHP 7.4 o superior
- Composer
- Extensiones PHP: curl, json, mbstring

## Instalación

### Composer

```bash
composer require facturas-billin/php-sdk
```

### Instalación manual

Si tienes el código fuente, ejecuta:

```bash
composer install
```

## Generación del SDK

El SDK se genera automáticamente a partir de la especificación OpenAPI/Swagger de la API de Facturas Billin.

Para regenerar el código, necesitas tener instalado [OpenAPI Generator CLI](https://openapi-generator.tech/docs/installation/) o Docker:

```bash
npm run generate
```

## Uso

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

use FacturasBillin\SDK\Configuration;
use FacturasBillin\SDK\Api\DefaultApi;

$config = Configuration::getDefaultConfiguration()->setApiKey('Authorization', 'YOUR_API_KEY');

$apiInstance = new DefaultApi(
    new GuzzleHttp\Client(),
    $config
);

try {
    // Usa las APIs generadas
    // $result = $apiInstance->someMethod();
    // print_r($result);
} catch (Exception $e) {
    echo 'Exception: ', $e->getMessage(), PHP_EOL;
}
?>
```

## Testing

```bash
composer test
```

O directamente:

```bash
vendor/bin/phpunit
```

## Documentación

La documentación de la API se genera automáticamente en el directorio `docs/` cuando se ejecuta el generador.

## Licencia

Este proyecto es no oficial y se distribuye bajo la licencia Apache 2.0. Ver el archivo [LICENSE](../../LICENSE) en la raíz del repositorio.
