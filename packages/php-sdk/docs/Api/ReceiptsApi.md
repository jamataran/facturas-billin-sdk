# FacturasBillin\SDK\ReceiptsApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createReceipt()**](ReceiptsApi.md#createReceipt) | **POST** /v1/invoices/sales-receipts | Create a receipt |


## `createReceipt()`

```php
createReceipt($create_receipt_request): \FacturasBillin\SDK\Model\SalesReceiptDocumentAnswerDto
```

Create a receipt

Endpoint to create a receipt

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\ReceiptsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$create_receipt_request = {"currency":"EUR","lines":[{"name":"Product name","quantity":2,"unitPrice":10,"totalAmount":21.78,"discountAmount":2,"taxKey":"IVA_21","taxAmount":3.78,"salesEqTaxAmount":0}]}; // \FacturasBillin\SDK\Model\CreateReceiptRequest | If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others

try {
    $result = $apiInstance->createReceipt($create_receipt_request);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling ReceiptsApi->createReceipt: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **create_receipt_request** | [**\FacturasBillin\SDK\Model\CreateReceiptRequest**](../Model/CreateReceiptRequest.md)| If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\SalesReceiptDocumentAnswerDto**](../Model/SalesReceiptDocumentAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
