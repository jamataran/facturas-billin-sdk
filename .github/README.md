# CI/CD y modelo de ramas

Esta carpeta documenta cómo integran código los desarrolladores, qué pasa
cuando se abre una PR, y cómo se publica una nueva versión del SDK.

## Modelo de ramas (GitFlow ligero)

```
main         ──●──────────●──────────●─────  (sólo releases — cada commit es publicable, tag vX.Y.Z)
                ▲           ▲           ▲
                │ release/  │ hotfix/   │ release/
                │           │           │
develop  ──●────●─────●─────●─────●─────●──   (rama de integración, default para PRs de feature)
            ▲     ▲                ▲
            │     │                │
       feature/  feature/      feature/
```

| Rama | Propósito | Origen | Destino | Quién la crea |
|------|-----------|--------|---------|---------------|
| `main` | Código publicado en GitHub Packages. **Protegida.** | – | – | – |
| `develop` | Integración continua. Default para PRs de feature. **Protegida.** | – | – | – |
| `feature/<slug>` o `issues/<n>` | Nueva funcionalidad o issue | `develop` | `develop` (PR) | dev |
| `bugfix/<slug>` | Bug detectado en `develop` | `develop` | `develop` (PR) | dev |
| `release/v<X.Y.Z>` | Estabilización antes de publicar | `develop` | `main` (PR) + back-merge a `develop` | maintainer |
| `hotfix/v<X.Y.Z>` | Bug crítico en producción | `main` | `main` (PR) + back-merge a `develop` | maintainer |

> Si todavía no existe `develop`, créala una vez con
> `git checkout -b develop main && git push -u origin develop`
> y configúrala como rama por defecto en *Settings → Branches*.

## Flujo de un cambio normal (feature)

1. Desde `develop` actualizado, crea la rama: `git checkout -b feature/123-mi-cambio`.
2. Trabaja, commitea con mensajes [Conventional Commits](https://www.conventionalcommits.org/es/v1.0.0/) (`feat:`, `fix:`, `chore:`, `docs:`, …).
3. Antes de empujar, comprueba en local:
   ```bash
   npm run generate    # si has tocado el swagger
   npm run build       # debe pasar
   npm run test        # debe pasar
   ```
4. `git push -u origin feature/123-mi-cambio` → abre PR contra **`develop`**.
5. CI ejecuta `ci.yml` (build) y `test.yml` (matriz Java 11/17/21). Si está en verde y hay 1 review aprobada → squash & merge.
6. La PR no toca `main`, por lo que no se publica nada.

## Flujo de release

1. Cuando `develop` tiene los cambios que quieres publicar, crea la rama:
   ```bash
   git checkout -b release/v2.1.0 develop
   ```
2. Bumpea versión en los cuatro sitios del paquete (Java SDK):
   - `packages/java-sdk/pom.xml` → `<version>2.1.0</version>`
   - `packages/java-sdk/openapi-generator-config.yaml` → `artifactVersion: 2.1.0`
   - `packages/java-sdk/package.json` → `"version": "2.1.0"`
   - `packages/java-sdk/README.md` y `README.md` raíz → ejemplo de dependencia
3. Regenera, compila y testa localmente (`npm run generate && npm run build && npm run test`).
4. Commit y push: `git push -u origin release/v2.1.0`.
5. Abre PR de `release/v2.1.0` → **`main`**. CI corre los workflows de validación.
6. Tras aprobar y mergear (merge commit, no squash, para conservar la historia):
   - **`publish.yml`** se dispara por el `push` a `main` y publica a GitHub Packages.
   - Crea el tag y la release en GitHub:
     ```bash
     git checkout main && git pull
     git tag -a v2.1.0 -m "Java SDK 2.1.0"
     git push origin v2.1.0
     gh release create v2.1.0 --title "Java SDK v2.1.0" --notes-from-tag
     ```
7. Back-merge a `develop` para no perder el bump de versión:
   ```bash
   git checkout develop && git pull
   git merge --no-ff main
   git push origin develop
   ```

## Flujo de hotfix

1. `git checkout -b hotfix/v2.1.1 main`
2. Bumpea versión a `2.1.1` (sólo PATCH) y aplica el fix mínimo.
3. PR contra `main`. Tras merge, tag `v2.1.1` y release.
4. Back-merge a `develop`.

## Workflows de GitHub Actions

Los tres workflows en `.github/workflows/` son:

### `ci.yml` — validación rápida

| Item | Valor |
|------|-------|
| Trigger | `push` y `pull_request` a `main`/`develop` |
| Qué hace | Instala deps, regenera **sólo el SDK Java**, compila con Maven, verifica estructura |
| Falla si | El swagger no genera código válido o el código no compila |
| Tarda | ~1–2 min |

### `test.yml` — matriz de tests

| Item | Valor |
|------|-------|
| Trigger | `push` y `pull_request` a `main`/`develop` |
| Qué hace | Ejecuta `mvn -B test` sobre Java 11, 17 y 21 |
| Sube como artifact | `target/surefire-reports/` (30 días) |
| Nota | Los tests de `**/integration/**` están excluidos por surefire (necesitan credenciales reales). En local: `mvn -B verify -Dintegration` con `BILLIN_CLIENT_ID` y `BILLIN_CLIENT_SECRET` exportados |

### `publish.yml` — publicación a GitHub Packages

| Item | Valor |
|------|-------|
| Triggers | `push` a `main` con cambios en `packages/java-sdk/**` o `openapi-spec/**`; `release: published`; `workflow_dispatch` con input `version` |
| Qué hace | Regenera, compila, ejecuta tests (`continue-on-error: true`), opcionalmente bumpea versión vía `mvn versions:set`, y `mvn deploy` a `https://maven.pkg.github.com/jamataran/facturas-billin-sdk` |
| Sube como artifact | `target/*.jar` (90 días) |
| Permisos requeridos | `packages: write` (ya configurado) |

> ⚠️ **Solapamiento de triggers**: si haces push a `main` (release merge) y *además*
> creas una GitHub Release con tag, el workflow se ejecuta dos veces. Está bien porque
> Maven Deploy es idempotente para versiones nuevas (la segunda fallaría con
> `409 Conflict`), pero si quieres evitarlo, restringe `publish.yml` a ejecutarse sólo
> en `release: published` y elimina el trigger de `push: main`.

## Reglas de protección de rama recomendadas

En *Settings → Branches → Branch protection rules*, para `main` y `develop`:

- ✅ Require a pull request before merging
- ✅ Require approvals: 1
- ✅ Require status checks to pass before merging:
  - `CI` (de `ci.yml`)
  - `Tests` (de `test.yml`, los 3 jobs de la matriz)
- ✅ Require branches to be up to date before merging
- ✅ Do not allow bypassing the above settings
- En `main`: **Restrict who can push** → sólo maintainers, y deshabilita force-push.

## Secretos y configuración

| Secret / variable | Dónde se usa | Cómo se obtiene |
|-------------------|--------------|-----------------|
| `GITHUB_TOKEN` | `publish.yml` (auto-inyectado por Actions) | – |
| `BILLIN_CLIENT_ID`, `BILLIN_CLIENT_SECRET` | tests de integración (en local, `.env.local`) | Panel de Billin |

> Los tests de integración no se ejecutan en CI porque no se han añadido los secretos.
> Si los añades en *Settings → Secrets and variables → Actions*, podrás incluir un job
> adicional que los inyecte como variables de entorno y ejecute `mvn -B verify`.

## Checklist para una release

- [ ] `develop` está verde (CI + Tests).
- [ ] Versión bumpada en los 4 sitios del paquete.
- [ ] CHANGELOG actualizado (si existe) o release notes preparadas.
- [ ] Tests locales pasan: `npm run test`.
- [ ] PR `release/vX.Y.Z` → `main` aprobada y mergeada.
- [ ] Tag `vX.Y.Z` creado y pusheado.
- [ ] GitHub Release publicada.
- [ ] Workflow `publish.yml` finalizado en verde.
- [ ] Back-merge a `develop`.
- [ ] Anuncio (si aplica) en el README del paquete y en el README raíz.
