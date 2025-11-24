# Facturas Billin Java SDK

SDK no oficial en Java para consumir la API REST de [Facturas Billin](https://www.facturasbillin.net/).

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior

## Instalación

### Maven

Añade la siguiente dependencia a tu `pom.xml`:

```xml
<dependency>
    <groupId>net.facturasbillin</groupId>
    <artifactId>facturas-billin-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Generación del SDK

El SDK se genera automáticamente a partir de la especificación OpenAPI/Swagger de la API de Facturas Billin.

Para regenerar el código:

```bash
npm run generate
```

O directamente con Maven:

```bash
mvn org.openapitools:openapi-generator-maven-plugin:generate
```

## Compilación

```bash
npm run build
```

O directamente con Maven:

```bash
mvn clean package
```

## Uso

### Uso Básico con BillinProvider

```java
import net.facturasbillin.sdk.BillinProvider;
import net.facturasbillin.sdk.api.*;

public class Example {
    public static void main(String[] args) {
        // Inicializar el provider con tu API key
        String apiKey = System.getenv("BILLIN_API_KEY");
        BillinProvider provider = new BillinProvider(apiKey);
        
        // Obtener APIs para interactuar con los recursos
        ContactsApi contactsApi = provider.getContactsApi();
        InvoicesApi invoicesApi = provider.getInvoicesApi();
        ProductsApi productsApi = provider.getProductsApi();
        
        // Ejemplo: listar contactos
        try {
            // var contacts = contactsApi.getContactsList(...);
            // ... tu código aquí
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Uso Avanzado con ApiClient

```java
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.api.*;
import net.facturasbillin.sdk.model.*;

public class AdvancedExample {
    public static void main(String[] args) {
        // Configurar el cliente manualmente
        ApiClient client = new ApiClient();
        client.setBasePath("https://api.facturasbillin.net");
        client.setApiKey("YOUR_API_KEY");
        
        // Crear instancias de APIs
        ContactsApi contactsApi = new ContactsApi(client);
        
        // Usar las APIs
        try {
            // var response = contactsApi.someMethod(...);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Variables de Entorno

Es recomendable usar variables de entorno para la API key:

```bash
export BILLIN_API_KEY="tu-api-key-aqui"
```

O usar un archivo `.env.local` en la raíz del proyecto (ver `.env.example`).

## Testing

```bash
npm run test
```

O directamente con Maven:

```bash
mvn test
```

## Licencia

Este proyecto es no oficial y se distribuye bajo la licencia Apache 2.0. Ver el archivo [LICENSE](../../LICENSE) en la raíz del repositorio.
