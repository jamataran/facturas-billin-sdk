# FacturasBillin\SDK\ExpensesApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createExpense()**](ExpensesApi.md#createExpense) | **POST** /v1/expenses | Create an expense |
| [**getExpensesList()**](ExpensesApi.md#getExpensesList) | **GET** /v1/expenses | Get the expenses list |


## `createExpense()`

```php
createExpense($expense_create_dto): \FacturasBillin\SDK\Model\ExpenseDocumentAnswerDto
```

Create an expense

Endpoint to create an expense

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\ExpensesApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$expense_create_dto = {"identifier":"F20240011","issuedDate":"2024-03-20","lines":[{"name":"Potatoe","subtotal":10,"totalAmount":12.1,"taxKey":"IVA_21","taxAmount":2.1}],"currency":"EUR","contact":{"fiscalName":"Contact S.L.","vatNumberType":"NIF","vatNumber":"B12345678","address":{"postalAddress":"C/ México, 32","postalCode":"28820","city":"Madrid","country":"ES","province":"ES-M"}}}; // \FacturasBillin\SDK\Model\ExpenseCreateDto | - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - *Province* **is mandatory** for Spain country.

try {
    $result = $apiInstance->createExpense($expense_create_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling ExpensesApi->createExpense: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **expense_create_dto** | [**\FacturasBillin\SDK\Model\ExpenseCreateDto**](../Model/ExpenseCreateDto.md)| - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - *Province* **is mandatory** for Spain country. | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\ExpenseDocumentAnswerDto**](../Model/ExpenseDocumentAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getExpensesList()`

```php
getExpensesList($query_issued_date, $query_created_at, $query_updated_at, $query_identifier, $query_is_paid, $query_contact_vat_number, $sort_issued_date, $sort_created_at, $sort_updated_at, $sort_identifier, $limit, $offset): \FacturasBillin\SDK\Model\GetExpenseListAnswerDto
```

Get the expenses list

Endpoint to get the expenses list

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\ExpensesApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$query_issued_date = 'query_issued_date_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_created_at = 'query_created_at_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_updated_at = 'query_updated_at_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_identifier = 'query_identifier_example'; // string
$query_is_paid = True; // bool
$query_contact_vat_number = 'query_contact_vat_number_example'; // string
$sort_issued_date = 'sort_issued_date_example'; // string
$sort_created_at = 'sort_created_at_example'; // string
$sort_updated_at = 'sort_updated_at_example'; // string
$sort_identifier = 'sort_identifier_example'; // string
$limit = 10; // float
$offset = 0; // float

try {
    $result = $apiInstance->getExpensesList($query_issued_date, $query_created_at, $query_updated_at, $query_identifier, $query_is_paid, $query_contact_vat_number, $sort_issued_date, $sort_created_at, $sort_updated_at, $sort_identifier, $limit, $offset);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling ExpensesApi->getExpensesList: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **query_issued_date** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_created_at** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_updated_at** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_identifier** | **string**|  | [optional] |
| **query_is_paid** | **bool**|  | [optional] |
| **query_contact_vat_number** | **string**|  | [optional] |
| **sort_issued_date** | **string**|  | [optional] |
| **sort_created_at** | **string**|  | [optional] |
| **sort_updated_at** | **string**|  | [optional] |
| **sort_identifier** | **string**|  | [optional] |
| **limit** | **float**|  | [optional] [default to 10] |
| **offset** | **float**|  | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\GetExpenseListAnswerDto**](../Model/GetExpenseListAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
