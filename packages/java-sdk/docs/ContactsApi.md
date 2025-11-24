# ContactsApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createContact**](ContactsApi.md#createContact) | **POST** /v1/contacts | Create a contact |


<a id="createContact"></a>
# **createContact**
> ContactAnswerDto createContact(createContactDto)

Create a contact

Endpoint to create a contact

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.ContactsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    ContactsApi apiInstance = new ContactsApi(defaultClient);
    CreateContactDto createContactDto = new CreateContactDto(); // CreateContactDto | 
    try {
      ContactAnswerDto result = apiInstance.createContact(createContactDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactsApi#createContact");
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
| **createContactDto** | [**CreateContactDto**](CreateContactDto.md)|  | [optional] |

### Return type

[**ContactAnswerDto**](ContactAnswerDto.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** |  |  -  |
| **401** |  |  -  |
| **403** |  |  -  |

