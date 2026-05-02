# Facturas Billin SDK

Repositorio **NO OFICIAL** con SDKs para consumir la API REST de [Facturas Billin](https://www.facturasbillin.net/) en diferentes lenguajes de programación.

[![CI](https://github.com/jamataran/facturas-billin-sdk/actions/workflows/ci.yml/badge.svg)](https://github.com/jamataran/facturas-billin-sdk/actions/workflows/ci.yml)
[![Tests](https://github.com/jamataran/facturas-billin-sdk/actions/workflows/test.yml/badge.svg)](https://github.com/jamataran/facturas-billin-sdk/actions/workflows/test.yml)
[![Publish](https://github.com/jamataran/facturas-billin-sdk/actions/workflows/publish.yml/badge.svg)](https://github.com/jamataran/facturas-billin-sdk/actions/workflows/publish.yml)

## 📦 Paquetes Disponibles

| SDK | Versión | Estado |
|-----|---------|--------|
| [Java/Maven SDK](./packages/java-sdk) | 2.0.0 | ✅ Disponible |
| [PHP SDK](./packages/php-sdk) | 1.0.0 | 🚧 En desarrollo |

---

## 🚀 Uso Rápido - Java SDK

### 1. Añadir el repositorio de GitHub Packages

En tu `pom.xml`, añade el repositorio:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/jamataran/facturas-billin-sdk</url>
    </repository>
</repositories>
```

### 2. Añadir la dependencia

```xml
<dependency>
    <groupId>net.facturasbillin</groupId>
    <artifactId>facturas-billin-java-sdk</artifactId>
    <version>2.0.0</version>
</dependency>
```

### 3. Configurar autenticación a GitHub Packages

Crea o edita tu `~/.m2/settings.xml`:

```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>TU_USUARIO_GITHUB</username>
      <password>TU_TOKEN_GITHUB</password>
    </server>
  </servers>
</settings>
```

> 💡 Genera un token en [GitHub Settings > Developer settings > Personal access tokens](https://github.com/settings/tokens) con el permiso `read:packages`.

### 4. Usar el SDK

```java
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.api.AuthApi;
import net.facturasbillin.sdk.api.InvoicesApi;
import net.facturasbillin.sdk.model.*;

public class Example {
    public static void main(String[] args) throws Exception {
        // Configurar cliente
        ApiClient client = new ApiClient();
        
        // Autenticarse
        AuthApi authApi = new AuthApi(client);
        AuthInfoAnswerDto auth = authApi.login("tu_client_id", "tu_client_secret");
        
        // Usar el token en las siguientes peticiones
        client.setAccessToken(auth.getData().getAccessToken());
        
        // Obtener facturas
        InvoicesApi invoicesApi = new InvoicesApi(client);
        GetInvoicesListAnswerDto invoices = invoicesApi.getInvoices(null, null, null, null);
        
        System.out.println("Facturas: " + invoices.getData().size());
    }
}
```

📖 Para documentación completa, ver [Java SDK README](./packages/java-sdk/README.md)

---

## 🏗️ Estructura del Proyecto

```
facturas-billin-sdk/
├── packages/
│   ├── java-sdk/           # SDK para Java/Maven
│   └── php-sdk/            # SDK para PHP (en desarrollo)
├── openapi-spec/
│   └── swagger.json        # Especificación OpenAPI
├── .github/workflows/
│   ├── ci.yml              # CI: build y validación
│   ├── test.yml            # Tests en múltiples versiones Java
│   └── publish.yml         # Publicación a GitHub Packages
└── README.md
```

## 🔄 CI/CD

El proyecto utiliza GitHub Actions para automatizar:

| Workflow | Trigger | Descripción |
|----------|---------|-------------|
| **CI** | Push/PR a `main`, `develop` | Compila y valida todos los SDKs |
| **Tests** | Push/PR a `main`, `develop` | Ejecuta tests en Java 11, 17, 21 |
| **Publish** | Push a `main` | Publica el SDK a GitHub Packages |

### Publicación Automática

Cuando se hace push a `main`:
1. ✅ Se genera el SDK desde la especificación OpenAPI
2. ✅ Se compila y ejecutan los tests
3. ✅ Se publica a GitHub Packages
4. ✅ Se genera el JAR como artifact descargable

---

## 🛠️ Desarrollo Local

### Requisitos

- Node.js 18+
- Java 11+ y Maven 3.6+
- PHP 7.4+ y Composer (para PHP SDK)

### Instalación

```bash
git clone https://github.com/jamataran/facturas-billin-sdk.git
cd facturas-billin-sdk
npm install
```

### Comandos

El monorepo se orquesta con [Turborepo](https://turbo.build/repo). Estos son los comandos principales que ejecutas siempre desde la raíz:

```bash
npm run generate          # Regenera el SDK Java a partir de openapi-spec/swagger.json
npm run generate:java     # Solo Java (alias del anterior)
npm run generate:php      # Solo PHP
npm run generate:all      # Todos los SDKs en paralelo (vía turbo)

npm run build             # Compila todos los paquetes (turbo run build)
npm run build:java        # Solo Java
npm run build:php         # Solo PHP

npm run test              # Tests de todos los paquetes
npm run test:java
npm run test:php

npm run clean             # Limpia artefactos generados
```

> Turborepo cachea la salida de `generate` y `build` cuando ni `openapi-spec/**` ni la
> configuración del paquete han cambiado, por eso las ejecuciones repetidas son casi
> instantáneas. Si necesitas forzar la regeneración, usa `npx turbo run generate --force`.

Para más detalles de la organización del monorepo y de cómo añadir un nuevo SDK, revisa
[`CONTRIBUTING.md`](./CONTRIBUTING.md). Para los workflows de CI/CD y el modelo de ramas,
ver [`.github/README.md`](./.github/README.md).

---

## 📝 Licencia

Este proyecto se distribuye bajo la [Licencia Apache 2.0](./LICENSE).

## ⚠️ Disclaimer

Este es un proyecto **no oficial** y no está afiliado con Facturas Billin.

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Ver [CONTRIBUTING.md](./CONTRIBUTING.md) para más detalles.

## 📞 Soporte

- **API oficial**: [facturasbillin.net](https://www.facturasbillin.net/)
- **Issues del SDK**: [GitHub Issues](https://github.com/jamataran/facturas-billin-sdk/issues)
