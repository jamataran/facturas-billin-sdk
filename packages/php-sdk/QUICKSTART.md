# ⚡ Quick Start - Comienza en 2 minutos

## Paso 1: Instala el SDK

```bash
composer require facturas-billin/php-sdk
```

## Paso 2: Obtén tu token de acceso

```php
<?php
require_once 'vendor/autoload.php';

use FacturasBillin\SDK\BillinProvider;

// Opción A: Con token directo
$provider = new BillinProvider('tu-token-aqui');

// Opción B: Obtén el token automáticamente (OAuth2)
$provider = BillinProvider::withClientCredentials(
    'tu-client-id',
    'tu-client-secret'
);
```

## Paso 3: ¡Crea una factura!

```php
<?php
use FacturasBillin\SDK\Model\InvoiceCreateDto;
use FacturasBillin\SDK\Model\DocumentContactDto;
use FacturasBillin\SDK\Model\DocumentLineDto;

// Cliente
$contact = new DocumentContactDto();
$contact->setFiscalName('Tu Cliente S.L.');
$contact->setVatNumber('B12345678');

// Línea de factura
$line = new DocumentLineDto();
$line->setName('Producto ejemplo');
$line->setQuantity(1);
$line->setUnitPrice(100);
$line->setTotalAmount(121);
$line->setTaxKey('IVA_21');
$line->setTaxAmount(21);
$line->setDiscountAmount(0);
$line->setSalesEqTaxAmount(0);

// Crear factura
$invoice = new InvoiceCreateDto();
$invoice->setContact($contact);
$invoice->setLines([$line]);
$invoice->setCurrency(InvoiceCreateDto::CURRENCY_EUR);

// Enviar a la API
$resultado = $provider->getInvoicesApi()->createInvoice($invoice);

echo "✅ Factura creada: " . $resultado->getId();
```

## 🎯 Operaciones Principales

### Listar facturas
```php
$facturas = $provider->getInvoicesApi()->getInvoicesList();
foreach ($facturas as $f) {
    echo $f->getNumber() . " - " . $f->getTotal() . " EUR\n";
}
```

### Crear contacto
```php
use FacturasBillin\SDK\Model\CreateContactDto;

$contact = new CreateContactDto();
$contact->setFiscalName('Nueva Empresa');
$contact->setVatNumber('B87654321');

$provider->getContactsApi()->createContact($contact);
```

### Crear gasto
```php
use FacturasBillin\SDK\Model\ExpenseCreateDto;

$expense = new ExpenseCreateDto();
$expense->setDescription('Gasto');
$expense->setAmount(50);

$provider->getExpensesApi()->createExpense($expense);
```

## 📚 Documentación Completa

- [README completo](./README.md)
- [Ejemplos de uso](../EJEMPLOS_USO.md)
- [Configuración en PHP Storm](./PHPSTORM_SETUP.md)
- [Distribución y publicación](../DISTRIBUTION.md)

## ❓ ¿Problemas?

```bash
# Instala dependencias
composer install

# Ejecuta los tests para verificar
vendor/bin/phpunit

# En PHP Storm:
# - Abre Preferences → Languages & Frameworks → PHP → Test Frameworks
# - Configura con bootstrap.php y phpunit.xml
```

## 🚀 ¡Listo!

Ya puedes empezar a crear facturas con el SDK. 

¿Preguntas? Lee la [documentación completa](./README.md).

