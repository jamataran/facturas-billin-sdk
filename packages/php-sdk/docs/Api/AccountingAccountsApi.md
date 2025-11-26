# FacturasBillin\SDK\AccountingAccountsApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createAccountingAccount()**](AccountingAccountsApi.md#createAccountingAccount) | **POST** /v1/accounting-accounts | Create an accounting account |
| [**getAccountingAccountList()**](AccountingAccountsApi.md#getAccountingAccountList) | **GET** /v1/accounting-accounts | Get the accounting accounts list |


## `createAccountingAccount()`

```php
createAccountingAccount($create_accounting_account_dto): \FacturasBillin\SDK\Model\AccountingAccountAnswerDto
```

Create an accounting account

Endpoint to create an accounting account

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\AccountingAccountsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$create_accounting_account_dto = {"type":"CREDIT_CARD","alias":"Visa Oro","creditCardNumber":"1846","creditCardExpireDate":"01/23"}; // \FacturasBillin\SDK\Model\CreateAccountingAccountDto | There are are three types of accounting accounts. Each one of them expects a diferent payload:        - BANK_ACCOUNT: expects IBAN and SWIFT code.        - CREDIT_CARD: expects credit card number and expire date.        - CASH_REGISTER: expects no additional fields.

try {
    $result = $apiInstance->createAccountingAccount($create_accounting_account_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling AccountingAccountsApi->createAccountingAccount: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **create_accounting_account_dto** | [**\FacturasBillin\SDK\Model\CreateAccountingAccountDto**](../Model/CreateAccountingAccountDto.md)| There are are three types of accounting accounts. Each one of them expects a diferent payload:        - BANK_ACCOUNT: expects IBAN and SWIFT code.        - CREDIT_CARD: expects credit card number and expire date.        - CASH_REGISTER: expects no additional fields. | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\AccountingAccountAnswerDto**](../Model/AccountingAccountAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getAccountingAccountList()`

```php
getAccountingAccountList($query_type, $sort_created_at, $sort_updated_at, $sort_alias, $limit, $offset): \FacturasBillin\SDK\Model\AccountingAccountListAnswerDto
```

Get the accounting accounts list

Endpoint to get the accounting accounts list

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\AccountingAccountsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$query_type = 'query_type_example'; // string
$sort_created_at = 'sort_created_at_example'; // string
$sort_updated_at = 'sort_updated_at_example'; // string
$sort_alias = 'sort_alias_example'; // string
$limit = 10; // float
$offset = 0; // float

try {
    $result = $apiInstance->getAccountingAccountList($query_type, $sort_created_at, $sort_updated_at, $sort_alias, $limit, $offset);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling AccountingAccountsApi->getAccountingAccountList: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **query_type** | **string**|  | [optional] |
| **sort_created_at** | **string**|  | [optional] |
| **sort_updated_at** | **string**|  | [optional] |
| **sort_alias** | **string**|  | [optional] |
| **limit** | **float**|  | [optional] [default to 10] |
| **offset** | **float**|  | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\AccountingAccountListAnswerDto**](../Model/AccountingAccountListAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
