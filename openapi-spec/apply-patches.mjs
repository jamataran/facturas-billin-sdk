#!/usr/bin/env node
// Post-process the swagger.json synced from Billin into a separate file
// (swagger.patched.json) so the generated SDK is tolerant to mismatches
// between the spec and the live API — without ever mutating swagger.json.
//
// Keeping swagger.json untouched preserves traceability of upstream changes
// (a clean diff against Billin's published spec). Generators consume the
// patched file instead.
//
// Two passes, both idempotent:
//
//   1. Strip every `required: [...]` array from components.schemas. The
//      okhttp-gson generator emits a runtime check
//      (validateJsonElement -> "The required field `X` is not found")
//      that throws when the API omits a field the spec marks as required.
//      Billin marks fields required that they don't always return
//      (e.g. InvoiceDocumentAnswerDto.paymentMethods,
//      SalesReceiptAnswerDto.paymentMethods, PaymentAnswerDto.isReconciled
//      historically). Dropping `required` makes those fields deserialize
//      as null instead of throwing.
//
//   2. Set `additionalProperties: true` on every object-like schema. The
//      generator emits a second check ("The field `X` in the JSON string
//      is not defined in the `YDto` properties") that throws on unknown
//      fields. With `additionalProperties: true` the mustache template
//      skips that block, so new fields the API adds without bumping the
//      spec just get ignored instead of crashing the SDK.
//
// Note: extra runtime tolerance for type mismatches (e.g. the API returning
// `[]` where an object is expected) is implemented separately via the
// Mustache template overrides under packages/java-sdk/templates/. These two
// layers — spec patch + template override — are independent and complementary.
//
// Usage:
//   node openapi-spec/apply-patches.mjs            # write swagger.patched.json
//   node openapi-spec/apply-patches.mjs --check    # exit 1 if patched file is stale or missing
//
// This script is wired into `npm run generate:java` so manual invocation
// is only needed if you want to inspect the diff before regenerating.

import { readFileSync, writeFileSync, existsSync } from 'node:fs';
import { fileURLToPath } from 'node:url';
import { dirname, join } from 'node:path';

const here = dirname(fileURLToPath(import.meta.url));
const sourcePath = join(here, 'swagger.json');
const targetPath = join(here, 'swagger.patched.json');
const checkOnly = process.argv.includes('--check');

const original = readFileSync(sourcePath, 'utf-8');
const spec = JSON.parse(original);

let droppedRequired = 0;
let addedAdditionalProps = 0;

const schemas = spec?.components?.schemas ?? {};
for (const schema of Object.values(schemas)) {
  if (Array.isArray(schema.required)) {
    droppedRequired += schema.required.length;
    delete schema.required;
  }
  const isObjectLike = schema.type === 'object' || schema.properties;
  if (isObjectLike && !('additionalProperties' in schema)) {
    schema.additionalProperties = true;
    addedAdditionalProps++;
  }
}

const patched = JSON.stringify(spec, null, 2) + '\n';
const existing = existsSync(targetPath) ? readFileSync(targetPath, 'utf-8') : null;
const changed = patched !== existing;

if (checkOnly) {
  if (changed) {
    console.error(
      'swagger.patched.json is missing or stale. Run: npm run patch:spec'
    );
    process.exit(1);
  }
  console.log('swagger.patched.json is up to date.');
  process.exit(0);
}

if (changed) {
  writeFileSync(targetPath, patched);
}

console.log(
  `apply-patches: dropped ${droppedRequired} required entries, ` +
  `added additionalProperties:true on ${addedAdditionalProps} schemas ` +
  `(${changed ? 'swagger.patched.json rewritten' : 'no changes — already up to date'}). ` +
  `swagger.json was not modified.`
);
