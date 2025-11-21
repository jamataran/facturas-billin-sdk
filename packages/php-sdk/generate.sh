#!/bin/bash
# Generate PHP SDK using OpenAPI Generator

# Try Docker first (preferred method for consistency)
if command -v docker &> /dev/null; then
    echo "Using Docker to generate PHP SDK..."
    docker run --rm \
        --user "$(id -u):$(id -g)" \
        -v "${PWD}/../..:/workspace" \
        openapitools/openapi-generator-cli generate \
        -i /workspace/openapi-spec/swagger.json \
        -g php \
        -o /workspace/packages/php-sdk \
        -c /workspace/packages/php-sdk/openapi-generator-config.yaml
    exit $?
fi

# Fallback to local openapi-generator-cli
if command -v openapi-generator-cli &> /dev/null; then
    echo "Using local openapi-generator-cli to generate PHP SDK..."
    openapi-generator-cli generate \
        -i ../../openapi-spec/swagger.json \
        -g php \
        -o . \
        -c openapi-generator-config.yaml
    exit $?
fi

echo "Error: Neither Docker nor openapi-generator-cli are available."
echo "Please install one of them to generate the PHP SDK."
exit 1
