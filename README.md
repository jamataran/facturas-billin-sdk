# Facturas Billin SDK

SDKs no oficiales para consumir la API REST de [Facturas Billin](https://www.facturasbillin.net/).

## Lenguajes soportados

- **Java** → Maven Central Repository
- **PHP** → Packagist

## Instalación

### Java

```xml
<dependency>
    <groupId>net.facturasbillin</groupId>
    <artifactId>facturas-billin-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

[Java SDK - Documentación](./packages/java-sdk/README.md)

### PHP

```bash
composer require facturas-billin/php-sdk
```

[PHP SDK - Documentación](./packages/php-sdk/README.md)

## Uso básico

### Java

```java
ApiClient client = new ApiClient();
client.setAccessToken("tu-token");

InvoicesApi api = new InvoicesApi(client);
CreateInvoiceRequest request = new CreateInvoiceRequest();
// configurar request...
api.createInvoice(request);
```

### PHP

```php
$client = new BillinProvider("tu-api-key");
$invoicesApi = $client->getInvoicesApi();
$invoices = $invoicesApi->getInvoicesList();
```

## Desarrollo

```bash
git clone https://github.com/jamataran/facturas-billin-sdk.git
cd facturas-billin-sdk
npm install

npm run generate    # Regenerar desde OpenAPI spec
npm run build       # Compilar
npm run test        # Tests
```

## Licencia

Apache License 2.0

