# FacturasBillin\SDK\QuotesApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createQuote()**](QuotesApi.md#createQuote) | **POST** /v1/quotes | Create a quote |


## `createQuote()`

```php
createQuote($quote_create_dto): \FacturasBillin\SDK\Model\QuoteDocumentAnswerDto
```

Create a quote

Endpoint to create a quote

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\QuotesApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$quote_create_dto = {"currency":"EUR","lines":[{"name":"Product name","quantity":2,"unitPrice":10,"totalAmount":21.78,"discountAmount":2,"taxKey":"IVA_21","taxAmount":3.78,"salesEqTaxAmount":0}],"contact":{"fiscalName":"Contact S.L."}}; // \FacturasBillin\SDK\Model\QuoteCreateDto | - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority.

try {
    $result = $apiInstance->createQuote($quote_create_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling QuotesApi->createQuote: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **quote_create_dto** | [**\FacturasBillin\SDK\Model\QuoteCreateDto**](../Model/QuoteCreateDto.md)| - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority. | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\QuoteDocumentAnswerDto**](../Model/QuoteDocumentAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
