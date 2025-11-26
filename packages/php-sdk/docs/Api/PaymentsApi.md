# FacturasBillin\SDK\PaymentsApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createPayment()**](PaymentsApi.md#createPayment) | **POST** /v1/payments | Create a payment |
| [**getPaymentList()**](PaymentsApi.md#getPaymentList) | **GET** /v1/payments | Get payment list |


## `createPayment()`

```php
createPayment($create_payment_dto): \FacturasBillin\SDK\Model\PaymentAnswerDto
```

Create a payment

Endpoint to create a payment

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\PaymentsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$create_payment_dto = {"operationDate":"2024-03-04","amount":50,"type":"INCOME"}; // \FacturasBillin\SDK\Model\CreatePaymentDto | - There are two fields to set the **contact**, either by filling in the ***contactId*** field or the ***documentsId*** field. You can't send both, please provide **only one of them**.

try {
    $result = $apiInstance->createPayment($create_payment_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling PaymentsApi->createPayment: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **create_payment_dto** | [**\FacturasBillin\SDK\Model\CreatePaymentDto**](../Model/CreatePaymentDto.md)| - There are two fields to set the **contact**, either by filling in the ***contactId*** field or the ***documentsId*** field. You can&#39;t send both, please provide **only one of them**. | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\PaymentAnswerDto**](../Model/PaymentAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getPaymentList()`

```php
getPaymentList($sort_created_at, $sort_operation_date, $query_type, $query_method, $query_operation_date, $query_contact_id, $query_accounting_account_id, $limit, $offset): \FacturasBillin\SDK\Model\PaymentListAnswerDto
```

Get payment list

Endpoint to get the payment list

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\PaymentsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$sort_created_at = 'sort_created_at_example'; // string
$sort_operation_date = 'sort_operation_date_example'; // string
$query_type = 'query_type_example'; // string
$query_method = 'query_method_example'; // string
$query_operation_date = 'query_operation_date_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_contact_id = 'query_contact_id_example'; // string | The contact id of the payment
$query_accounting_account_id = 'query_accounting_account_id_example'; // string | The accounting account id of the payment
$limit = 10; // float
$offset = 0; // float

try {
    $result = $apiInstance->getPaymentList($sort_created_at, $sort_operation_date, $query_type, $query_method, $query_operation_date, $query_contact_id, $query_accounting_account_id, $limit, $offset);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling PaymentsApi->getPaymentList: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **sort_created_at** | **string**|  | [optional] |
| **sort_operation_date** | **string**|  | [optional] |
| **query_type** | **string**|  | [optional] |
| **query_method** | **string**|  | [optional] |
| **query_operation_date** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_contact_id** | **string**| The contact id of the payment | [optional] |
| **query_accounting_account_id** | **string**| The accounting account id of the payment | [optional] |
| **limit** | **float**|  | [optional] [default to 10] |
| **offset** | **float**|  | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\PaymentListAnswerDto**](../Model/PaymentListAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
