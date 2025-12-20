# ⚙️ Configuración de PHPUnit en PHP Storm

Este documento te guía paso a paso para configurar PHPUnit en PHP Storm correctamente.

## 🎯 Problema Original

Cuando intentabas ejecutar tests en PHP Storm, recibías:
```
PHPUnit settings are not configured.
```

Esto sucedía porque `phpunit.xml` estaba vacío y PHP Storm no sabía cómo ejecutar los tests.

## ✅ Solución Implementada

Se han creado/actualizado dos archivos críticos:

### 1. `phpunit.xml` (Nuevo)

Archivo de configuración de PHPUnit que especifica:
- Bootstrap (precarga de archivos)
- Estructura de tests
- Variables de entorno
- Cobertura de código

### 2. `bootstrap.php` (Nuevo)

Script que se ejecuta **antes** de cada test:
- Carga automáticamente `.env.local`
- Configura variables de entorno (`BILLIN_CLIENT_ID`, `BILLIN_CLIENT_SECRET`)
- Carga el autoloader de Composer

---

## 🔧 Configuración en PHP Storm (Paso a Paso)

### Paso 1: Abrir Preferencias/Configuración

- **macOS**: `PHPStorm` → `Preferences`
- **Linux/Windows**: `File` → `Settings`

### Paso 2: Navegar a Test Frameworks

Ruta completa:
```
Languages & Frameworks → PHP → Test Frameworks
```

### Paso 3: Agregar PHPUnit

1. Haz clic en el botón **`+`** (plus) en la esquina inferior izquierda
2. Selecciona **`PHPUnit`** de la lista

### Paso 4: Configurar PHPUnit

Completa los campos con las rutas correctas:

| Campo | Valor |
|-------|-------|
| **Name** | `PHPUnit` |
| **PHPUnit library** | `/Users/jose/PROYECTOS/OSS/facturas-billin-sdk/packages/php-sdk/vendor/autoload.php` |
| **Default configuration file** | `/Users/jose/PROYECTOS/OSS/facturas-billin-sdk/packages/php-sdk/phpunit.xml` |
| **Default bootstrap file** | `/Users/jose/PROYECTOS/OSS/facturas-billin-sdk/packages/php-sdk/bootstrap.php` |

> **Nota**: Ajusta la ruta con tu usuario y ruta real del proyecto.

### Paso 5: Aplicar Cambios

1. Haz clic en **`OK`**
2. Ahora PHPUnit está configurado en PHP Storm

---

## ✨ Usar PHPUnit en PHP Storm

### Ejecutar un test completo

1. Abre el archivo `test/Integration/CreateInvoiceTest.php`
2. Verás pequeños iconos de play ▶️ a la izquierda de la clase
3. Haz clic en uno de ellos:
   - **Play en la clase**: Ejecuta todos los métodos de test
   - **Play en un método**: Ejecuta solo ese método

### Ejecutar con cobertura

1. Click derecho en el archivo de test
2. Selecciona: **`Run 'CreateInvoiceTest' with Coverage`**
3. Se mostrará un reporte de cobertura de código

### Ejecutar con debug

1. Haz click en el icono de play
2. Luego selecciona **`Debug 'CreateInvoiceTest'`**
3. Los breakpoints se activarán

---

## 🔐 Variables de Entorno

### Primera ejecución

Antes de ejecutar tests, necesitas credenciales válidas de Billin:

```bash
cd /Users/jose/PROYECTOS/OSS/facturas-billin-sdk/packages/php-sdk

# Ver el archivo de ejemplo
cat .env.example

# Crear tu archivo local
cp .env.example .env.local

# Editar con tus credenciales
nano .env.local
```

El archivo `.env.local` debe contener:
```env
BILLIN_CLIENT_ID=tu_client_id_aqui
BILLIN_CLIENT_SECRET=tu_client_secret_aqui
```

### ⚠️ Importante

- **NO hagas commit** del archivo `.env.local` (está en `.gitignore`)
- El `.env.local` es personal y contiene datos sensibles
- Cada desarrollador debe tener su propia copia
- El `bootstrap.php` carga automáticamente estas variables para los tests

---

## 📋 Estructura de Tests

Los tests están organizados en dos suites:

### Unit Tests
```
test/
├── Model/              ← Pruebas de modelos
└── Api/                ← Pruebas de APIs
```

Ejecutar:
```bash
vendor/bin/phpunit --testsuite Unit
```

### Integration Tests
```
test/
└── Integration/        ← Pruebas con API real
    └── CreateInvoiceTest.php
```

Ejecutar:
```bash
vendor/bin/phpunit --testsuite Integration
```

---

## 🐛 Solución de Problemas

### Problema: "PHPUnit settings are not configured"

**Solución**: Vuelve a verificar los pasos 1-5 anteriores. El archivo `phpunit.xml` debe existir.

### Problema: Tests no encuentran las clases

**Solución**: Asegúrate de que ejecutaste:
```bash
composer install
```

### Problema: Variables de entorno no se cargan

**Solución**: 
1. Verifica que `.env.local` existe y tiene credenciales
2. Reinicia PHP Storm completamente
3. Vuelve a configurar el bootstrap file en Preferences

### Problema: "Class not found: FacturasBillin\SDK\BillinProvider"

**Solución**: El autoloader de Composer no se está cargando. Verifica que `bootstrap.php` está configurado correctamente.

---

## ✅ Verificar que todo funciona

Ejecuta este test simple:

```bash
cd /Users/jose/PROYECTOS/OSS/facturas-billin-sdk/packages/php-sdk
vendor/bin/phpunit --filter testBillinProviderInstantiation
```

Debería ver:
```
✅ BillinProviderInstantiation test is correct!
OK (1 test, 1 assertion)
```

---

## 📚 Referencias

- [Documentación oficial de PHPUnit](https://phpunit.de/)
- [Integración de PHPUnit en PHPStorm](https://www.jetbrains.com/help/phpstorm/using-phpunit.html)
- [Bootstrap en PHPUnit](https://docs.phpunit.de/en/9.5/configuration.html#the-bootstrap-attribute)

