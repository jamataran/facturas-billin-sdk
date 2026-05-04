# OpenAPI Specification

Esta carpeta contiene la especificación OpenAPI/Swagger de la API de Facturas Billin
y el patcher que la prepara para los generadores de SDK.

## Archivos

- `swagger.json` — especificación OpenAPI 3.0 sincronizada desde Billin **y parcheada**
  para tolerar discrepancias entre spec y API (ver más abajo).
- `apply-patches.mjs` — script idempotente que aplica los parches.

## Parches aplicados

El swagger oficial de Billin tiene dos clases de discrepancia recurrentes con la API
real, y el código generado por `openapi-generator` (template `okhttp-gson`) las
convierte en `IllegalArgumentException` en tiempo de deserialización:

1. **Campos `required` que la API no devuelve** — por ejemplo
   `InvoiceDocumentAnswerDto.paymentMethods`. La validación generada exige presencia,
   y la respuesta lanza
   `The required field paymentMethods is not found in the JSON string`.
2. **Campos nuevos que la API devuelve antes de aparecer en el spec** — por ejemplo
   `PaymentAnswerDto.isReconciled` cuando se introdujo. La validación generada
   rechaza claves no declaradas con
   `The field X in the JSON string is not defined in the YDto properties`.

`apply-patches.mjs` neutraliza ambos casos a nivel de spec:

- Elimina **todos** los arrays `required` de `components.schemas` → los campos
  ausentes deserializan como `null` en lugar de lanzar excepción.
- Añade `additionalProperties: true` a todos los esquemas tipo objeto → la
  plantilla mustache omite el bloque que rechaza claves no declaradas.

Es **idempotente** (puedes ejecutarlo varias veces sin efecto adicional) y se
encadena automáticamente antes de cada `npm run generate:*`.

## Cómo actualizar la especificación

1. Sustituye `swagger.json` por el archivo nuevo descargado de Billin.
2. Ejecuta `npm run patch:spec` (o directamente `npm run generate:java`, que lo
   incluye). Verás algo como:
   ```
   apply-patches: dropped 250 required entries, added additionalProperties:true on 70 schemas (spec rewritten).
   ```
3. Compila y ejecuta tests: `npm run build && npm run test`.
4. Revisa el diff de los DTOs Java generados — los cambios son los que tienes que
   reflejar en el changelog y en los tests de integración (enums nuevos, firmas
   distintas, DTOs renombrados).

## Verificar que el spec está parcheado en CI

```bash
npm run patch:spec:check
```

Sale con código 1 si el spec no está parcheado. Útil para añadirlo a un workflow
de validación si quieres bloquear PRs que olviden ejecutar el patcher.

## Recursos

- [OpenAPI Specification](https://swagger.io/specification/)
- [OpenAPI Generator (Java)](https://openapi-generator.tech/docs/generators/java/)
- [Facturas Billin API](https://www.facturasbillin.net/api)
