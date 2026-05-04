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
    <version>2.0.1</version>
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
mvn clean package -DskipTests
```

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

## Uso

```java
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.api.*;
import net.facturasbillin.sdk.model.*;

public class Example {
    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setBasePath("https://api.facturasbillin.net");
        
        // Configura autenticación
        client.setApiKey("YOUR_API_KEY");
        
        // Usa las APIs generadas
        InvoicesApi api = new InvoicesApi(client);
        // ... tu código aquí
    }
}
```

## Testing

### Tests de Integración

Para ejecutar los tests de integración (requiere `.env.local` configurado):

```bash
npm run test
```

O directamente con Maven:

```bash
mvn test
```

**Nota**: Los tests generados automáticamente son un punto de partida y pueden necesitar ajustes según tu implementación específica.

### Build sin Tests

Si deseas compilar sin ejecutar tests:

```bash
npm run build
```

O con Maven:

```bash
mvn clean package -DskipTests
```

## Estructura del Proyecto

```
java-sdk/
├── src/
│   ├── main/java/net/facturasbillin/sdk/    # Código generado
│   └── test/java/net/facturasbillin/sdk/    # Tests generados
├── pom.xml                                   # Configuración Maven
├── .env.example                              # Template de variables
├── .env.local                                # Variables reales (NO commitear)
└── README.md
```

## Licencia

Este proyecto es no oficial y se distribuye bajo la licencia Apache 2.0. Ver el archivo [LICENSE](../../LICENSE) en la raíz del repositorio.
