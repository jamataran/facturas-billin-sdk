# AuthApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**authControllerGetInfoV1**](AuthApi.md#authControllerGetInfoV1) | **GET** /v1/auth/info | Get user info |
| [**authControllerGetTokenV1**](AuthApi.md#authControllerGetTokenV1) | **POST** /v1/auth/token | OAuth2 authentication |


<a id="authControllerGetInfoV1"></a>
# **authControllerGetInfoV1**
> AuthInfoAnswerDto authControllerGetInfoV1()

Get user info

Endpoint that gets the basic info from the user that generated the API credentials

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.AuthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    AuthApi apiInstance = new AuthApi(defaultClient);
    try {
      AuthInfoAnswerDto result = apiInstance.authControllerGetInfoV1();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthApi#authControllerGetInfoV1");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AuthInfoAnswerDto**](AuthInfoAnswerDto.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **201** |  |  -  |
| **401** |  |  -  |

<a id="authControllerGetTokenV1"></a>
# **authControllerGetTokenV1**
> TokenAnswerDto authControllerGetTokenV1(requestTokenUserApiCredentialDto)

OAuth2 authentication

Endpoint that validates credentials following the flows specified in OAuth2. If validates succesfully, returns an access token and a refresh token

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.AuthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");

    AuthApi apiInstance = new AuthApi(defaultClient);
    RequestTokenUserApiCredentialDto requestTokenUserApiCredentialDto = new RequestTokenUserApiCredentialDto(); // RequestTokenUserApiCredentialDto | Currently there are three authentication flows: client_credentials, password and refresh_token. Not all of them are available to all users
    try {
      TokenAnswerDto result = apiInstance.authControllerGetTokenV1(requestTokenUserApiCredentialDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthApi#authControllerGetTokenV1");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **requestTokenUserApiCredentialDto** | [**RequestTokenUserApiCredentialDto**](RequestTokenUserApiCredentialDto.md)| Currently there are three authentication flows: client_credentials, password and refresh_token. Not all of them are available to all users | [optional] |

### Return type

[**TokenAnswerDto**](TokenAnswerDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** |  |  -  |
| **401** |  |  -  |

