# FacturasBillin\SDK\AuthApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**authControllerGetInfoV1()**](AuthApi.md#authControllerGetInfoV1) | **GET** /v1/auth/info | Get user info |
| [**authControllerGetTokenV1()**](AuthApi.md#authControllerGetTokenV1) | **POST** /v1/auth/token | OAuth2 authentication |


## `authControllerGetInfoV1()`

```php
authControllerGetInfoV1(): \FacturasBillin\SDK\Model\AuthInfoAnswerDto
```

Get user info

Endpoint that gets the basic info from the user that generated the API credentials

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\AuthApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->authControllerGetInfoV1();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling AuthApi->authControllerGetInfoV1: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\FacturasBillin\SDK\Model\AuthInfoAnswerDto**](../Model/AuthInfoAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `authControllerGetTokenV1()`

```php
authControllerGetTokenV1($request_token_user_api_credential_dto): \FacturasBillin\SDK\Model\TokenAnswerDto
```

OAuth2 authentication

Endpoint that validates credentials following the flows specified in OAuth2. If validates succesfully, returns an access token and a refresh token

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');



$apiInstance = new FacturasBillin\SDK\Api\AuthApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$request_token_user_api_credential_dto = {"grantType":"client_credentials","clientId":"<your client id>","clientSecret":"<your client secret>"}; // \FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto | Currently there are three authentication flows: client_credentials, password and refresh_token. Not all of them are available to all users

try {
    $result = $apiInstance->authControllerGetTokenV1($request_token_user_api_credential_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling AuthApi->authControllerGetTokenV1: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **request_token_user_api_credential_dto** | [**\FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto**](../Model/RequestTokenUserApiCredentialDto.md)| Currently there are three authentication flows: client_credentials, password and refresh_token. Not all of them are available to all users | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\TokenAnswerDto**](../Model/TokenAnswerDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
