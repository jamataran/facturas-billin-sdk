# FacturasBillin\SDK\ProductsApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createProduct()**](ProductsApi.md#createProduct) | **POST** /v1/products | Create a product |


## `createProduct()`

```php
createProduct($create_product_dto): \FacturasBillin\SDK\Model\ProductAnswerDto
```

Create a product

Endpoint to create a product

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\ProductsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$create_product_dto = {"name":"Potato","taxKey":"IVA_7_5"}; // \FacturasBillin\SDK\Model\CreateProductDto | - At least one of the two fields *sellingPrice* or *retailPrice* is mandatory.

try {
    $result = $apiInstance->createProduct($create_product_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling ProductsApi->createProduct: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **create_product_dto** | [**\FacturasBillin\SDK\Model\CreateProductDto**](../Model/CreateProductDto.md)| - At least one of the two fields *sellingPrice* or *retailPrice* is mandatory. | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\ProductAnswerDto**](../Model/ProductAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
