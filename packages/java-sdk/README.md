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

```java
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.api.*;
import net.facturasbillin.sdk.model.*;

public class Example {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setApiKey("YOUR_API_KEY");
        
        // Usa las APIs generadas
        // DefaultApi api = new DefaultApi(client);
        // ... tu código aquí
    }
}
```

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
