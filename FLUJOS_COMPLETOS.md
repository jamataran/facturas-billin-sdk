# 🔄 Flujos Completos - Visual

## 📊 FLUJO 1: Desarrollo Local

```
┌─────────────────────────────────────────────────────────────────┐
│                     DESARROLLADOR LOCAL                         │
└─────────────────────────────────────────────────────────────────┘
                              ↓
                  ┌───────────────────────┐
                  │  composer install     │
                  └───────────────────────┘
                              ↓
                  ┌───────────────────────┐
                  │ cp .env.example →     │
                  │ .env.local            │
                  └───────────────────────┘
                              ↓
              ┌───────────────────────────────────┐
              │  Edita .env.local con sus        │
              │  credenciales de Billin           │
              └───────────────────────────────────┘
                              ↓
           ┌──────────────────────────────────────────┐
           │  Configura PHP Storm:                   │
           │  Preferences → Test Frameworks →        │
           │  PHP → PHPUnit                          │
           │                                         │
           │  ✓ PHPUnit library: vendor/autoload.php│
           │  ✓ Config file: phpunit.xml            │
           │  ✓ Bootstrap: bootstrap.php            │
           └──────────────────────────────────────────┘
                              ↓
              ┌───────────────────────────────────┐
              │  Abre CreateInvoiceTest.php       │
              │  Hace click en el ▶️ para ejecutar │
              │                                   │
              │  ✅ TESTS FUNCIONAN               │
              └───────────────────────────────────┘
                              ↓
                  ┌───────────────────────┐
                  │  Lee README.md para   │
                  │  ejemplos y casos     │
                  │  de uso               │
                  └───────────────────────┘
                              ↓
                  ┌───────────────────────┐
                  │  Integra SDK en       │
                  │  su aplicación        │
                  └───────────────────────┘
```

---

## 🚀 FLUJO 2: Publicación (Primera Vez)

```
┌──────────────────────────────────────────────────────────────────┐
│                    SETUP DE PUBLICACIÓN                         │
│                    (UNA SOLA VEZ)                               │
└──────────────────────────────────────────────────────────────────┘

                    ┌─────────────┐
                    │   JAVA SDK  │                PHP SDK
                    └─────────────┘                └──────────┘
                          ↓                              ↓
        ┌─────────────────────────────┐  ┌──────────────────────────┐
        │ 1. Registrarse en           │  │ 1. Registrarse en        │
        │    Sonatype JIRA            │  │    Packagist.org         │
        └─────────────────────────────┘  └──────────────────────────┘
                    ↓                              ↓
        ┌─────────────────────────────┐  ┌──────────────────────────┐
        │ 2. Crear ticket para        │  │ 2. Hacer submit con      │
        │    proyecto "net.billin"    │  │    URL del repo GitHub   │
        └─────────────────────────────┘  └──────────────────────────┘
                    ↓                              ↓
        ┌─────────────────────────────┐  ┌──────────────────────────┐
        │ 3. Configurar GPG signing   │  │ 3. ¡Listo! Se actualiza  │
        │    en pom.xml               │  │    automáticamente con   │
        └─────────────────────────────┘  │    cada push a GitHub    │
                    ↓                     └──────────────────────────┘
        ┌─────────────────────────────┐
        │ 4. Esperar aprobación       │
        │    (puede tomar días)       │
        └─────────────────────────────┘
                    ↓
        ┌─────────────────────────────┐
        │ ✅ LISTO para publicar      │
        └─────────────────────────────┘
```

---

## 📦 FLUJO 3: Publicación (Cada Actualización)

```
┌──────────────────────────────────────────────────────────────────┐
│              PUBLICAR ACTUALIZACIÓN EN GITHUB                   │
│                  (CADA VEZ QUE HAY CAMBIOS)                    │
└──────────────────────────────────────────────────────────────────┘
                          ↓
                ┌──────────────────────┐
                │ 1. Actualizar spec   │
                │    OpenAPI           │
                │                      │
                │ openapi-spec/        │
                │ swagger.json         │
                └──────────────────────┘
                          ↓
                ┌──────────────────────┐
                │ 2. Regenerar SDKs    │
                │                      │
                │ npm run generate     │
                └──────────────────────┘
                          ↓
                ┌──────────────────────┐
                │ 3. Compilar y testear│
                │                      │
                │ npm run build        │
                │ npm run test         │
                └──────────────────────┘
                          ↓
                ┌──────────────────────┐
                │ 4. Actualizar        │
                │    versiones:        │
                │                      │
                │ pom.xml: v1.x.x      │
                │ composer.json: v1.x.x│
                └──────────────────────┘
                          ↓
                ┌──────────────────────┐
                │ 5. Commit + Push     │
                │                      │
                │ git add .            │
                │ git commit -m "..."  │
                │ git push origin main │
                └──────────────────────┘
                          ↓
                ┌──────────────────────┐
                │ 6. Crear tag         │
                │                      │
                │ git tag v1.x.x       │
                │ git push --tags      │
                └──────────────────────┘
                          ↓
    ┌───────────────────────┐────────────────────┐
    ↓                       ↓                    ↓
┌─────────────┐    ┌─────────────────┐   ┌──────────────┐
│ Maven       │    │ Packagist       │   │ GitHub       │
│ Central     │    │ se actualiza    │   │ Release page │
│ se         │    │ automáticamente │   │              │
│ actualiza   │    │ (minutos)       │   │ (crea tag)   │
│ (horas)    │    └─────────────────┘   └──────────────┘
└─────────────┘
    ↓
┌─────────────────────────────────────────────────────┐
│  ✅ NUEVA VERSIÓN DISPONIBLE PARA DESCARGAR         │
│                                                     │
│  Java:                                              │
│  mvnrepository.com → Buscar "facturas-billin"     │
│                                                     │
│  PHP:                                               │
│  packagist.org → Buscar "facturas-billin/php-sdk" │
└─────────────────────────────────────────────────────┘
```

---

## 👥 FLUJO 4: Un Desarrollador Usando tu SDK

```
┌──────────────────────────────────────────────────────────────────┐
│                  DESARROLLADOR EXTERNO                          │
│              (Quiere usar tu SDK)                               │
└──────────────────────────────────────────────────────────────────┘
                          ↓
                    ┌─────────────┐
                    │  OPCIÓN 1   │          OPCIÓN 2
                    │   JAVA      │          ────────
                    └─────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ 1. Agregar a pom.xml:        │
           │                              │
           │ <dependency>                 │
           │   <groupId>                  │
           │     net.facturasbillin       │
           │   </groupId>                 │
           │   <artifactId>               │
           │     facturas-billin-java-sdk │
           │   </artifactId>              │
           │ </dependency>                │
           └──────────────────────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ 2. Maven descarga de         │
           │    Maven Central             │
           │    automáticamente           │
           └──────────────────────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ 3. Usa en su código:         │
           │                              │
           │ new BillinProvider(token)    │
           │   .getInvoicesApi()          │
           │   .createInvoice(invoice)    │
           └──────────────────────────────┘
                          ↓
                    ┌──────────────┐
                    │ ✅ LISTO      │
                    │ Funciona      │
                    └──────────────┘

─────────────────────────────────────────────────────────

                          ↓
                    ┌─────────────┐
                    │  OPCIÓN 2   │
                    │    PHP      │
                    └─────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ 1. Ejecutar en terminal:     │
           │                              │
           │ composer require             │
           │  facturas-billin/php-sdk     │
           └──────────────────────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ 2. Composer descarga de      │
           │    Packagist automáticamente │
           └──────────────────────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ 3. Usa en su código:         │
           │                              │
           │ $provider =                  │
           │   new BillinProvider(token)  │
           │ $provider->getInvoicesApi()  │
           │   ->createInvoice($invoice)  │
           └──────────────────────────────┘
                          ↓
                    ┌──────────────┐
                    │ ✅ LISTO      │
                    │ Funciona      │
                    └──────────────┘
```

---

## 🔐 FLUJO 5: Variables de Entorno (Local)

```
┌──────────────────────────────────────────────────────────────────┐
│                    GESTIÓN DE CREDENCIALES                      │
└──────────────────────────────────────────────────────────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ .env.example                 │
           │ (plantilla pública)          │
           │                              │
           │ BILLIN_CLIENT_ID=tu_id       │
           │ BILLIN_CLIENT_SECRET=tu_sec  │
           │                              │
           │ ✅ SE SUBE AL REPO          │
           └──────────────────────────────┘
                          ↓
           Cada desarrollador copia:
                          ↓
           ┌──────────────────────────────┐
           │ .env.local (privado)         │
           │                              │
           │ BILLIN_CLIENT_ID=abc123      │
           │ BILLIN_CLIENT_SECRET=xyz456  │
           │                              │
           │ ❌ NO SE SUBE (en .gitignore)│
           └──────────────────────────────┘
                          ↓
           bootstrap.php lo carga:
                          ↓
           ┌──────────────────────────────┐
           │ putenv() y $_ENV[]           │
           │ Variables disponibles en     │
           │ los tests                    │
           └──────────────────────────────┘
                          ↓
           ┌──────────────────────────────┐
           │ CreateInvoiceTest.php        │
           │ getenv('BILLIN_CLIENT_ID')   │
           │ getenv('BILLIN_CLIENT_SECRET')│
           │                              │
           │ ✅ CREDENCIALES CARGADAS     │
           └──────────────────────────────┘
```

---

## 📚 FLUJO 6: Documentación

```
┌──────────────────────────────────────────────────────────────────┐
│                    RUTA DE DOCUMENTACIÓN                        │
└──────────────────────────────────────────────────────────────────┘

                    NUEVO USUARIO
                         ↓
        ┌────────────────────────────────┐
        │ ¿Qué es esto?                  │
        │                                │
        │ → README.md (raíz)             │
        └────────────────────────────────┘
                         ↓
        ┌────────────────────────────────┐
        │ Quiero empezar ya              │
        │                                │
        │ → QUICKSTART.md                │
        │   (2 minutos)                  │
        └────────────────────────────────┘
                         ↓
        ┌────────────────────────────────┐
        │ ¿Cómo funciona en PHP Storm?   │
        │                                │
        │ → PHPSTORM_SETUP.md            │
        │   (Paso a paso)                │
        └────────────────────────────────┘
                         ↓
        ┌────────────────────────────────┐
        │ Quiero ejemplos de código      │
        │                                │
        │ → EJEMPLOS_USO.md              │
        │   (4 casos reales)             │
        └────────────────────────────────┘
                         ↓
        ┌────────────────────────────────┐
        │ README del PHP SDK             │
        │                                │
        │ → packages/php-sdk/README.md   │
        │   (Documentación completa)     │
        └────────────────────────────────┘
                         ↓
        ┌────────────────────────────────┐
        │ ¿Cómo publico esto?            │
        │                                │
        │ → DISTRIBUTION.md              │
        │   (Flujo de publicación)       │
        └────────────────────────────────┘
```

---

## 🎯 RESUMEN

Todos estos flujos están **completamente implementados y documentados**. 

Tu SDK está listo para:
- ✅ Desarrollo local (con tests en PHP Storm)
- ✅ Publicación automática (Maven Central + Packagist)
- ✅ Uso por otros desarrolladores (fácil instalación)
- ✅ Documentación clara (en español)

¡Todo funciona! 🚀

