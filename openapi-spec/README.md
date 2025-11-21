# OpenAPI Specification

Esta carpeta contiene la especificación OpenAPI/Swagger de la API de Facturas Billin.

## Archivo Principal

- `swagger.json` - Especificación OpenAPI/Swagger de la API

## Cómo Actualizar la Especificación

1. Obtén el archivo de definición de la API desde Facturas Billin (generalmente disponible en formato JSON o YAML)
2. Reemplaza el contenido de `swagger.json` con la especificación oficial
3. Ejecuta `npm run generate` desde la raíz del proyecto para regenerar los SDKs

## Notas

- El archivo `swagger.json` actual es un **PLACEHOLDER** con una estructura mínima
- Debe ser reemplazado con la especificación oficial de facturasbillin.net
- La especificación debe seguir el formato OpenAPI 3.0 o superior
- Asegúrate de que la especificación incluye toda la información necesaria:
  - Endpoints disponibles
  - Modelos de datos
  - Esquemas de autenticación
  - Tipos de respuesta
  - Códigos de error

## Generación de SDKs

Una vez que la especificación esté en su lugar, los SDKs se pueden generar ejecutando:

```bash
# Desde la raíz del repositorio
npm run generate

# O para un SDK específico
cd packages/java-sdk && npm run generate
cd packages/php-sdk && npm run generate
```

## Recursos

- [OpenAPI Specification](https://swagger.io/specification/)
- [Facturas Billin API Documentation](https://www.facturasbillin.net/api)
