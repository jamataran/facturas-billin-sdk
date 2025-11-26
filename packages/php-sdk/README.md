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

**Nota**: El comando de generación utiliza la bandera `--skip-validate-spec` debido a un problema de validación menor en la especificación OpenAPI (el atributo `components.schemas.ExpenseDocumentAnswerDto.default` no es de tipo `object`). Esto no afecta a la funcionalidad del SDK generado.

## Uso

### Opción 1: Usando BillinProvider (Recomendado)

El `BillinProvider` ofrece una interfaz simplificada para interactuar con la API de Billin:

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

use FacturasBillin\SDK\BillinProvider;
use FacturasBillin\SDK\Model\InvoiceCreateDto;
use FacturasBillin\SDK\Model\DocumentContactDto;
use FacturasBillin\SDK\Model\DocumentLineDto;

// Opción A: Autenticación con token ya obtenido
$provider = new BillinProvider('your-access-token');

// Opción B: Autenticación automática con client credentials (OAuth2)
$provider = BillinProvider::withClientCredentials(
    'your-client-id',
    'your-client-secret'
);

// Crear una factura
$contact = new DocumentContactDto();
$contact->setFiscalName('Cliente S.L.');

$line = new DocumentLineDto();
$line->setName('Producto');
$line->setQuantity(2);
$line->setUnitPrice(10);
$line->setTaxKey('IVA_21');
$line->setTaxAmount(4.20);
$line->setTotalAmount(24.20);
$line->setSalesEqTaxAmount(0);
$line->setDiscountAmount(0);

$invoice = new InvoiceCreateDto();
$invoice->setContact($contact);
$invoice->setLines([$line]);
$invoice->setCurrency(InvoiceCreateDto::CURRENCY_EUR);

try {
    $result = $provider->getInvoicesApi()->createInvoice($invoice);
    echo "Factura creada con ID: " . $result->getId();
} catch (\Exception $e) {
    echo 'Error: ' . $e->getMessage();
}
```

### Opción 2: Usando APIs directamente

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

use FacturasBillin\SDK\Configuration;
use FacturasBillin\SDK\Api\InvoicesApi;
use GuzzleHttp\Client;

$config = Configuration::getDefaultConfiguration()
    ->setAccessToken('your-bearer-token');

$invoicesApi = new InvoicesApi(
    new Client(),
    $config
);

try {
    $invoices = $invoicesApi->getInvoicesList();
    print_r($invoices);
} catch (\Exception $e) {
    echo 'Error: ' . $e->getMessage();
}
```

### APIs Disponibles

El SDK proporciona acceso a las siguientes APIs a través del `BillinProvider`:

| Método | Descripción |
|--------|-------------|
| `getAuthApi()` | Autenticación OAuth2 |
| `getInvoicesApi()` | Gestión de facturas |
| `getReceiptsApi()` | Gestión de tickets/recibos |
| `getExpensesApi()` | Gestión de gastos |
| `getContactsApi()` | Gestión de contactos |
| `getProductsApi()` | Gestión de productos |
| `getPaymentsApi()` | Gestión de pagos |
| `getQuotesApi()` | Gestión de presupuestos |
| `getAccountingAccountsApi()` | Gestión de cuentas contables |

## Configuración de Variables de Entorno

Antes de ejecutar tests, configura el archivo `.env.local`:

```bash
# Copiar el template
cp .env.example .env.local

# Editar con tus credenciales
nano .env.local
```

El archivo `.env.local` debe contener:
```env
BILLIN_CLIENT_ID=tu_client_id
BILLIN_CLIENT_SECRET=tu_client_secret
```

## Testing

```bash
composer test
```

O directamente:

```bash
vendor/bin/phpunit
```

### Tests de Integración

Para ejecutar los tests de integración (requiere `.env.local` configurado o variables de entorno):

```bash
BILLIN_CLIENT_ID=your_id BILLIN_CLIENT_SECRET=your_secret vendor/bin/phpunit test/Integration/
```

## Estructura del Proyecto

```
php-sdk/
├── lib/
│   ├── Api/                  # Clases de API generadas
│   ├── Model/                # Modelos de datos generados
│   ├── BillinProvider.php    # Wrapper simplificado (custom)
│   ├── Configuration.php     # Configuración del SDK
│   └── ...
├── test/
│   ├── Api/                  # Tests de API
│   ├── Integration/          # Tests de integración
│   └── Model/                # Tests de modelos
├── docs/                     # Documentación generada
├── composer.json             # Dependencias
└── README.md
```

## Documentación

La documentación de la API se genera automáticamente en el directorio `docs/` cuando se ejecuta el generador.

## Licencia

Este proyecto es no oficial y se distribuye bajo la licencia Apache 2.0. Ver el archivo [LICENSE](../../LICENSE) en la raíz del repositorio.
