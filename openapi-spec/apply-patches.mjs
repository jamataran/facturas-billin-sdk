#!/usr/bin/env node
// Post-process the swagger.json synced from Billin so the generated SDK is
// tolerant to mismatches between the spec and the live API.
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
// Usage:
//   node openapi-spec/apply-patches.mjs            # patch in-place
//   node openapi-spec/apply-patches.mjs --check    # exit 1 if not patched
//
// This script is wired into `npm run generate:java` so manual invocation
// is only needed if you want to inspect the diff before regenerating.

import { readFileSync, writeFileSync } from 'node:fs';
import { fileURLToPath } from 'node:url';
import { dirname, join } from 'node:path';

const here = dirname(fileURLToPath(import.meta.url));
const specPath = join(here, 'swagger.json');
const checkOnly = process.argv.includes('--check');

const original = readFileSync(specPath, 'utf-8');
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
const changed = patched !== original;

if (checkOnly) {
  if (changed) {
    console.error('swagger.json has not been patched. Run: npm run patch:spec');
    process.exit(1);
  }
  console.log('swagger.json is already patched.');
  process.exit(0);
}

if (changed) {
  writeFileSync(specPath, patched);
}

console.log(
  `apply-patches: dropped ${droppedRequired} required entries, ` +
  `added additionalProperties:true on ${addedAdditionalProps} schemas ` +
  `(${changed ? 'spec rewritten' : 'no changes — already patched'}).`
);
