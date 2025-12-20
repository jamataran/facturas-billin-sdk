# Distribución y Publicación de SDKs

Respuestas a las preguntas sobre distribución de los SDKs.

## 1. ¿Hay equivalente a Packagist solo con GitHub?

**Sí, pero depende del lenguaje:**

### Java
- ✅ **Maven Central Repository** (usado actualmente)
- Distribuyen automáticamente desde GitHub tags/releases
- No requiere intermediarios

### PHP
Tienes 3 opciones:

| Opción | Descripción | Setup | Ventajas |
|--------|-------------|-------|----------|
| **Packagist** ⭐ | Repositorio oficial PHP | Automático | Es el standard de PHP, fácil búsqueda, cero config |
| **GitHub Packages** | Package registry de GitHub | Manual + workflow | Mismo lugar que el código, total control |
| **Solo GitHub** | Instalar desde repo directo | Manual composer | Funciona pero no recomendado |

**Recomendación:** Usa **Packagist** (como Maven Central en Java) - es lo que todos esperan en PHP.

---

## 2. ¿Cómo se sube a GitHub Packages?

Necesitas un workflow similar al Java. Actualmente no está configurado. Aquí va la solución:

### Opción A: GitHub Packages (alternativa a Packagist)

Crear `.github/workflows/publish-php.yml`:

```yaml
name: Publish PHP to GitHub Packages

on:
  release:
    types: [created]

jobs:
  publish:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      
      - name: Setup PHP
        uses: shivammathur/setup-php@v2
        with:
          php-version: '8.1'
          extensions: curl, json
          tools: composer:v2
      
      - name: Install dependencies
        working-directory: packages/php-sdk
        run: composer install
      
      - name: Configure Composer
        working-directory: packages/php-sdk
        env:
          COMPOSER_AUTH: |
            {
              "github-oauth": {
                "github.com": "${{ secrets.GITHUB_TOKEN }}"
              }
            }
        run: |
          composer config repositories.github composer https://packages.github.com/jamataran/facturas-billin-sdk
```

### Opción B: Packagist (RECOMENDADO - más fácil)

1. Ve a https://packagist.org/register y crea cuenta
2. Ve a https://packagist.org/packages/submit
3. Pega la URL: `https://github.com/jamataran/facturas-billin-sdk`
4. ¡Listo! Se sincroniza automáticamente con GitHub

**No requiere workflow, GitHub Packagist se conecta automáticamente.**

---

## 3. ¿Cómo lo usan los clientes?

### Con Packagist (RECOMENDADO)

```bash
composer require facturas-billin/php-sdk
```

Igual que cualquier paquete PHP estándar. Buscan en packagist.org:
https://packagist.org/packages/facturas-billin/php-sdk

### Con GitHub Packages

```bash
# Configurar composer para acceder a GitHub
composer config repositories.github composer https://packages.github.com/jamataran/facturas-billin-sdk

# Instalar
composer require jamataran/facturas-billin-sdk
```

Requiere que el usuario configure GitHub como repositorio (más trabajo para ellos).

### Directo desde GitHub (NO recomendado)

```bash
composer require github.com/jamataran/facturas-billin-sdk:main
```

Funciona pero es lento y frágil.

---

## 4. Comparación: Java vs PHP

### Java → Maven Central

```xml
<!-- usuario simplemente agrega a pom.xml -->
<dependency>
    <groupId>net.facturasbillin</groupId>
    <artifactId>facturas-billin-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

- Publicación: Manual (requiere credenciales en settings.xml)
- Búsqueda: mvnrepository.com
- Usuarios no hacen nada especial

### PHP → Packagist (equivalente)

```bash
# usuario simplemente ejecuta
composer require facturas-billin/php-sdk
```

- Publicación: Automática (solo conectar repo)
- Búsqueda: packagist.org
- Usuarios no hacen nada especial

---

## 5. Flujo de publicación completo

### Primera vez (SETUP)

#### Java

```bash
# Ya está configurado en pom.xml
# Solo falta agregar credenciales Maven en ~/.m2/settings.xml
# Ver: https://central.sonatype.org/publish/publish-maven/
```

#### PHP

```bash
# 1. Crear cuenta Packagist
# 2. Ir a https://packagist.org/packages/submit
# 3. Pegar: https://github.com/jamataran/facturas-billin-sdk
# 4. Autorizar a Packagist acceder a GitHub
# Listo, automático
```

### Cada actualización

```bash
# Cambiar versión en pom.xml y composer.json
# Por ejemplo de 1.0.0 a 1.0.1

# Commit y crear tag
git add .
git commit -m "Release v1.0.1: descripción"
git tag v1.0.1
git push origin main --tags

# Automáticamente:
# ✅ Maven Central detecta el tag y publica (si está bien configurado)
# ✅ Packagist detecta el tag y publica (sin hacer nada)
```

---

## 6. ¿Cuál elegir para PHP?

| Criterio | Packagist | GitHub Packages |
|----------|-----------|-----------------|
| **Facilidad setup** | 5 minutos | 30 minutos |
| **Facilidad uso clientes** | `composer require` | Necesita config GitHub |
| **Búsqueda** | packagist.org | GitHub search |
| **Automatización** | Total | Total |
| **Estándar PHP** | ✅ Sí | No |
| **Costo** | Free | Free |

**Recomendación final: PACKAGIST**

Es lo que todos los desarrolladores PHP esperan y usan. Cero config después de conectar el repo.

---

## Resumen de tus preguntas

| Pregunta | Respuesta |
|----------|-----------|
| ¿Hay algo como Packagist solo GitHub? | Para PHP: GitHub Packages (pero Packagist es mejor) |
| ¿Cómo lo subo a GitHub? | Con Packagist: solo conectar repo (automático) |
| ¿Cómo lo usan clientes? | `composer require facturas-billin/php-sdk` |
| ¿README general + específico? | ✅ Hecho (README.md raíz + packages/php-sdk/README.md) |
| ¿Sin IA-isms? | ✅ Documentación profesional y concisa |

---

## Próximos pasos

1. **Conectar Packagist** (5 minutos):
   - Ir a packagist.org/packages/submit
   - Pegar `https://github.com/jamataran/facturas-billin-sdk`
   - Autorizar

2. **Versionar y etiquetar**:
   ```bash
   git tag v1.0.0
   git push origin main --tags
   ```

3. **Publicado automáticamente** ✅

¡Listo para que cualquier desarrollador instale con `composer require`!

