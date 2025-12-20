# Checklist de Publicación

## Antes de publicar

### Documentación
- [x] README.md (raíz) - Visión general
- [x] packages/java-sdk/README.md - Específico Java
- [x] packages/php-sdk/README.md - Específico PHP
- [x] DISTRIBUCION_RESUELTO.md - Guía de distribución
- [ ] Revisar toda la documentación una última vez

### Código
- [ ] Probar que ambos SDKs compilan
- [ ] Ejecutar tests: `npm run test`
- [ ] Verificar que bootstrap.php está en el repo (SI, inclúyelo)

### Versiones
- [ ] Actualizar versión en `packages/java-sdk/pom.xml`
- [ ] Actualizar versión en `packages/php-sdk/composer.json`
- [ ] Usar Semantic Versioning (MAJOR.MINOR.PATCH)

## Publicación

### Setup inicial (UNA SOLA VEZ)

#### Packagist (PHP)
```bash
# 1. Ir a https://packagist.org/register
# 2. Crear cuenta

# 3. Ir a https://packagist.org/packages/submit
# 4. Pegar: https://github.com/jamataran/facturas-billin-sdk
# 5. Autorizar acceso a GitHub
```

#### Maven Central (Java)
```bash
# Ya debería estar configurado de tu publicación anterior
# Si no lo está, ver:
# https://central.sonatype.org/publish/publish-maven/
```

### Crear release

```bash
# 1. Commit
git add .
git commit -m "Release v1.0.0: descripción de cambios"

# 2. Tag
git tag v1.0.0

# 3. Push (esto activa la publicación automática)
git push origin main --tags
```

### Verificar publicación

**PHP (Packagist):**
```
https://packagist.org/packages/facturas-billin/php-sdk
```
Debería aparecer en ~5 minutos.

**Java (Maven):**
```
https://mvnrepository.com/artifact/net.facturasbillin/facturas-billin-java-sdk
```
Puede tardar horas.

## Después de publicar

### Usuarios pueden instalar

**Java:**
```xml
<dependency>
    <groupId>net.facturasbillin</groupId>
    <artifactId>facturas-billin-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

**PHP:**
```bash
composer require facturas-billin/php-sdk
```

### Próximas actualizaciones

1. Cambiar versión en pom.xml y composer.json
2. Commit + Tag + Push
3. ¡Publicación automática! ✅

No hay más pasos.

## Preguntas frecuentes

**P: ¿Bootstrap.php se sube?**
A: SÍ. Es parte del SDK. Solo NO se sube `.env.local` (credenciales).

**P: ¿A dónde se sube PHP?**
A: Packagist (equivalente a Maven Central). Setup: 5 minutos.

**P: ¿Cómo lo instalan los clientes?**
A: `composer require facturas-billin/php-sdk` (igual que Maven).

**P: ¿Tengo que hacer algo cada vez que actualizo?**
A: Solo: cambiar versión → git tag → git push origin main --tags

**P: ¿Hay workflows automáticos?**
A: SÍ. GitHub + Packagist + Maven Central = automático.

---

**Estado actual: LISTO PARA PUBLICAR** ✅

