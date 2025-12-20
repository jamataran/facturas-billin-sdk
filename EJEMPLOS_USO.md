# 💡 Guía Práctica de Uso - Ejemplos en Español

Esta guía muestra cómo los desarrolladores usarán tu SDK en proyectos reales.

---

## 🏗️ Proyecto Ejemplo: Sistema de Facturación

Imagina que alguien quiere crear un sistema simple de facturación para su negocio.

### Paso 1: Instalar el SDK

```bash
composer require facturas-billin/php-sdk
```

### Paso 2: Obtener credenciales de Billin

Se registra en [Billin](https://www.facturasbillin.net/) y obtiene:
```
BILLIN_CLIENT_ID=abc123xyz
BILLIN_CLIENT_SECRET=secreto456
```

### Paso 3: Código de la aplicación

#### Opción A: La forma simple (recomendada)

```php
<?php
require_once 'vendor/autoload.php';

use FacturasBillin\SDK\BillinProvider;
use FacturasBillin\SDK\Model\InvoiceCreateDto;
use FacturasBillin\SDK\Model\DocumentContactDto;
use FacturasBillin\SDK\Model\DocumentLineDto;
use FacturasBillin\SDK\Model\DocumentContactAddressDto;

// Conectar a la API de Billin
$provider = new BillinProvider('your-access-token');

// Definir cliente
$contact = new DocumentContactDto();
$contact->setFiscalName('Empresa XYZ S.L.');
$contact->setVatNumber('B12345678');
$contact->setVatNumberType(DocumentContactDto::VAT_NUMBER_TYPE_NIF);
$contact->setEmail('info@empresaxyz.com');
$contact->setPhone('913456789');

// Definir dirección
$address = new DocumentContactAddressDto();
$address->setPostalAddress('Calle Principal, 123');
$address->setPostalCode('28001');
$address->setCity('Madrid');
$address->setProvince('ES-M');
$address->setCountry(DocumentContactAddressDto::COUNTRY_ES);
$contact->setAddress($address);

// Crear línea de factura (producto vendido)
$line = new DocumentLineDto();
$line->setName('Servicio de consultoría');
$line->setQuantity(1);
$line->setUnitPrice(500);
$line->setTotalAmount(605);
$line->setTaxKey('IVA_21');
$line->setTaxAmount(105);
$line->setDiscountAmount(0);
$line->setSalesEqTaxAmount(0);

// Crear factura
$invoice = new InvoiceCreateDto();
$invoice->setContact($contact);
$invoice->setLines([$line]);
$invoice->setCurrency(InvoiceCreateDto::CURRENCY_EUR);

try {
    $result = $provider->getInvoicesApi()->createInvoice($invoice);
    echo "✅ Factura creada exitosamente!";
    echo "   ID: " . $result->getId();
    echo "   Número: " . $result->getNumber();
} catch (\Exception $e) {
    echo "❌ Error: " . $e->getMessage();
}
```

---

## 🔐 Autenticación: Opciones

### Opción 1: Con Token (simple)

Si ya tienes un token válido:

```php
<?php
require_once 'vendor/autoload.php';

use FacturasBillin\SDK\BillinProvider;

$provider = new BillinProvider('token-ya-obtenido-123abc');
$facturas = $provider->getInvoicesApi()->getInvoicesList();
```

### Opción 2: Con Client Credentials (automático)

El SDK obtiene el token automáticamente:

```php
<?php
require_once 'vendor/autoload.php';

use FacturasBillin\SDK\BillinProvider;

// El SDK obtiene el token automáticamente
$provider = BillinProvider::withClientCredentials(
    'tu-client-id',
    'tu-client-secret'
);

$facturas = $provider->getInvoicesApi()->getInvoicesList();
```

### Opción 3: Configuración avanzada

Para casos especiales:

```php
<?php
require_once 'vendor/autoload.php';

use FacturasBillin\SDK\Configuration;
use FacturasBillin\SDK\Api\InvoicesApi;
use GuzzleHttp\Client;

$config = new Configuration();
$config->setHost('https://api.billin.net');
$config->setAccessToken('token-123');
$config->setConnectTimeout(5);
$config->setRequestTimeout(10);

$client = new Client([
    'timeout' => 10,
    'connect_timeout' => 5,
]);

$api = new InvoicesApi($client, $config);
$resultado = $api->createInvoice($invoice);
```

---

## 📊 Casos de Uso Reales

### Caso 1: Sistema Web de E-commerce

```php
<?php
// Cuando se confirma un pedido en la tienda

use FacturasBillin\SDK\BillinProvider;
use FacturasBillin\SDK\Model\InvoiceCreateDto;
use FacturasBillin\SDK\Model\DocumentContactDto;
use FacturasBillin\SDK\Model\DocumentLineDto;

class OrderProcessor {
    private $billinProvider;
    
    public function __construct($accessToken) {
        $this->billinProvider = new BillinProvider($accessToken);
    }
    
    public function processOrder($pedido) {
        // Extraer datos del pedido
        $cliente = $pedido['cliente'];
        $items = $pedido['items'];
        
        // Crear contacto
        $contact = new DocumentContactDto();
        $contact->setFiscalName($cliente['nombre']);
        $contact->setVatNumber($cliente['nif']);
        $contact->setEmail($cliente['email']);
        
        // Crear líneas de factura
        $lines = [];
        foreach ($items as $item) {
            $line = new DocumentLineDto();
            $line->setName($item['nombre']);
            $line->setQuantity($item['cantidad']);
            $line->setUnitPrice($item['precio']);
            $line->setTotalAmount($item['total']);
            $line->setTaxKey('IVA_21');
            $line->setTaxAmount($item['impuesto']);
            $lines[] = $line;
        }
        
        // Crear factura en Billin
        $invoice = new InvoiceCreateDto();
        $invoice->setContact($contact);
        $invoice->setLines($lines);
        $invoice->setCurrency(InvoiceCreateDto::CURRENCY_EUR);
        
        $resultado = $this->billinProvider
            ->getInvoicesApi()
            ->createInvoice($invoice);
            
        return [
            'exito' => true,
            'id_billin' => $resultado->getId(),
            'numero_factura' => $resultado->getNumber(),
        ];
    }
}
```

### Caso 2: Script de Migración de Datos

```php
<?php
// Migrar facturas antiguas a Billin

use FacturasBillin\SDK\BillinProvider;

$provider = BillinProvider::withClientCredentials(
    getenv('CLIENT_ID'),
    getenv('CLIENT_SECRET')
);

// Leer desde base de datos antigua
$facturas_antiguas = $bd->query("SELECT * FROM facturas");

foreach ($facturas_antiguas as $factura_vieja) {
    try {
        // Crear factura en Billin
        $nueva_factura = convertirAlSDK($factura_vieja);
        $resultado = $provider->getInvoicesApi()->createInvoice($nueva_factura);
        
        // Guardar ID de Billin en base de datos
        $bd->update('facturas', [
            'id_billin' => $resultado->getId()
        ], ['id' => $factura_vieja['id']]);
        
        echo "✅ Factura {$factura_vieja['numero']} migrada\n";
    } catch (\Exception $e) {
        echo "❌ Error migrando factura: {$e->getMessage()}\n";
    }
}
```

### Caso 3: API REST propia

```php
<?php
// Crear un endpoint REST que genere facturas

header('Content-Type: application/json');

use FacturasBillin\SDK\BillinProvider;
use FacturasBillin\SDK\Model\InvoiceCreateDto;

try {
    $datos = json_decode(file_get_contents('php://input'), true);
    
    $provider = new BillinProvider($_ENV['BILLIN_TOKEN']);
    
    // Validar datos
    if (empty($datos['cliente']) || empty($datos['lineas'])) {
        throw new Exception('Datos incompletos');
    }
    
    // Construir factura (código omitido por brevedad)
    $invoice = new InvoiceCreateDto();
    // ... configurar ...
    
    $resultado = $provider->getInvoicesApi()->createInvoice($invoice);
    
    echo json_encode([
        'exito' => true,
        'factura_id' => $resultado->getId(),
        'numero' => $resultado->getNumber(),
    ]);
} catch (\Exception $e) {
    http_response_code(400);
    echo json_encode([
        'exito' => false,
        'error' => $e->getMessage(),
    ]);
}
```

### Caso 4: Operaciones en Lote

```php
<?php
// Procesar múltiples facturas

use FacturasBillin\SDK\BillinProvider;

$provider = BillinProvider::withClientCredentials(
    'client-id',
    'client-secret'
);

$invoicesApi = $provider->getInvoicesApi();

// Crear facturas
for ($i = 1; $i <= 100; $i++) {
    try {
        $invoice = crearFactura($i);
        $resultado = $invoicesApi->createInvoice($invoice);
        echo "✅ Factura $i creada (ID: {$resultado->getId()})\n";
    } catch (\Exception $e) {
        echo "❌ Error en factura $i: {$e->getMessage()}\n";
    }
    
    // Pequeña pausa para no sobrecargar
    sleep(1);
}

// Listar todas las facturas creadas
$query = new GetInvoicesListQueryDto();
$query->setPage(1);
$query->setLimit(50);

$lista = $invoicesApi->getInvoicesList($query);
echo "\nTotal de facturas creadas: " . count($lista) . "\n";
```

---

## 🛠️ Operaciones Comunes

### Crear un contacto

```php
<?php
$contact = new CreateContactDto();
$contact->setFiscalName('Nueva Empresa S.L.');
$contact->setVatNumber('B87654321');
$contact->setVatNumberType(CreateContactDto::VAT_NUMBER_TYPE_NIF);
$contact->setEmail('info@empresa.com');

$resultado = $provider->getContactsApi()->createContact($contact);
echo "Contacto creado: " . $resultado->getId();
```

### Listar facturas con filtros

```php
<?php
$query = new GetInvoicesListQueryDto();
$query->setPage(1);
$query->setLimit(25);
// Opcional: agregar filtros de fecha, estado, etc.

$facturas = $provider->getInvoicesApi()->getInvoicesList($query);

foreach ($facturas as $factura) {
    echo "Número: " . $factura->getNumber() . "\n";
    echo "Total: " . $factura->getTotal() . " EUR\n";
    echo "---\n";
}
```

### Crear un gasto

```php
<?php
$expense = new ExpenseCreateDto();
$expense->setDescription('Compra de materiales');
$expense->setDate(new DateTime());
$expense->setAmount(250.50);

$resultado = $provider->getExpensesApi()->createExpense($expense);
echo "Gasto creado: " . $resultado->getId();
```

### Crear un presupuesto

```php
<?php
$quote = new QuoteCreateDto();
// ... configurar presupuesto ...

$resultado = $provider->getQuotesApi()->createQuote($quote);
echo "Presupuesto creado: " . $resultado->getId();
```

---

## 🔄 Manejo de Errores

```php
<?php
try {
    $resultado = $provider->getInvoicesApi()->createInvoice($invoice);
} catch (ApiException $e) {
    // Error de la API (código HTTP, por ejemplo)
    echo "Error de API: " . $e->getResponseBody();
} catch (\InvalidArgumentException $e) {
    // Datos inválidos
    echo "Validación fallida: " . $e->getMessage();
} catch (\Exception $e) {
    // Error genérico
    echo "Error inesperado: " . $e->getMessage();
}
```

---

## 📦 Integración en composer.json

```json
{
    "name": "tu-empresa/mi-app",
    "require": {
        "php": "^7.4",
        "facturas-billin/php-sdk": "^1.0",
        "symfony/dotenv": "^5.0"
    },
    "require-dev": {
        "phpunit/phpunit": "^9.0"
    }
}
```

---

## ✅ Conclusión

Con tu SDK, los desarrolladores pueden:

✅ Instalar con un simple `composer require`  
✅ Crear facturas en 20 líneas de código  
✅ Gestionar clientes, gastos, presupuestos  
✅ Integrar fácilmente en aplicaciones web  
✅ Procesar datos en lote  
✅ Migrar datos de sistemas antiguos  

**¡Todo esto sin necesidad de leer documentación de API compleja!** 🚀

