# FacturasBillin\SDK\ContactsApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createContact()**](ContactsApi.md#createContact) | **POST** /v1/contacts | Create a contact |


## `createContact()`

```php
createContact($create_contact_dto): \FacturasBillin\SDK\Model\ContactAnswerDto
```

Create a contact

Endpoint to create a contact

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\ContactsApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$create_contact_dto = {"fiscalName":"Contact S.L."}; // \FacturasBillin\SDK\Model\CreateContactDto

try {
    $result = $apiInstance->createContact($create_contact_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling ContactsApi->createContact: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **create_contact_dto** | [**\FacturasBillin\SDK\Model\CreateContactDto**](../Model/CreateContactDto.md)|  | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\ContactAnswerDto**](../Model/ContactAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
