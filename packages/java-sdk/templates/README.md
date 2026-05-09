# Mustache template overrides

These files override the OpenAPI Generator templates that ship inside
`openapi-generator-7.2.0.jar` (library `okhttp-gson`). The Maven plugin is
configured to read this directory via `<templateDirectory>` in `pom.xml`; any
file present here takes precedence over the embedded template with the same
name. Anything not present here falls back to the embedded version.

## Why this exists

The Billin API and the published OpenAPI spec drift constantly. We already
patch the spec itself in `openapi-spec/apply-patches.mjs` to drop spurious
`required` markers and accept unknown fields, but the generated DTOs still
crash at runtime when the API returns a value of the wrong **shape** — most
commonly `[]` where the spec declares an object (see
`InvoiceDocumentAnswerDto.additionalExpenses`).

The override here injects targeted tolerance into every generated DTO without
touching `swagger.json`:

- `validateJsonElement` returns early if the payload is not a JSON object,
  and the rest of the body is wrapped in a `try { ... } catch (RuntimeException
  ignored) { ... }` so per-field type mismatches are swallowed instead of
  thrown.
- The custom Gson `read` adapter returns `null` when the payload is not a
  JSON object, and wraps `thisAdapter.fromJsonTree(...)` in a try/catch so a
  single malformed field can't blow up the entire response.
- The "unknown additional property" loop wraps each entry in try/catch so an
  exotic value type doesn't crash the loop.

The end result: any field the API returns in an unexpected shape is silently
dropped (set to `null`), and the rest of the DTO deserializes normally.

## Updating these templates

If you bump the OpenAPI Generator version in `pom.xml`, re-extract the
upstream template and re-apply the diff:

```bash
unzip -p ~/.m2/repository/org/openapitools/openapi-generator/<version>/openapi-generator-<version>.jar \
  Java/libraries/okhttp-gson/pojo.mustache > /tmp/pojo.upstream.mustache
diff /tmp/pojo.upstream.mustache templates/pojo.mustache
```

Look for upstream changes to `validateJsonElement` or the `read` adapter and
fold them in by hand.
