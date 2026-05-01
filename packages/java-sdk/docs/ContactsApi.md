# ContactsApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createContact**](ContactsApi.md#createContact) | **POST** /v1/contacts | Create a contact |
| [**getContactsList**](ContactsApi.md#getContactsList) | **GET** /v1/contacts | Get the contacts list |


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

<a id="getContactsList"></a>
# **getContactsList**
> ContactListAnswerDto getContactsList(queryVatNumber, queryIsCustomer, queryIsProvider, sortFiscalName, sortVatNumber, sortUpdatedAt, sortCreatedAt, limit, offset)

Get the contacts list

Endpoint to get the list of contacts for the business.  **Important limitation:**  Swagger UI does not correctly serialize nested query parameters with brackets when using the \&quot;Try it out\&quot; feature. As a result, requests built through the Swagger interface may not match the expected format and may return incorrect results.  To use advanced filters reliably, construct the URL manually or use an external HTTP client (Postman, curl, etc.).

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
    String queryVatNumber = "queryVatNumber_example"; // String | Filter by exact VAT number
    Boolean queryIsCustomer = true; // Boolean | Filter by customer flag
    Boolean queryIsProvider = true; // Boolean | Filter by provider flag
    String sortFiscalName = "ASC"; // String | 
    String sortVatNumber = "ASC"; // String | 
    String sortUpdatedAt = "ASC"; // String | 
    String sortCreatedAt = "ASC"; // String | 
    BigDecimal limit = new BigDecimal("10"); // BigDecimal | 
    BigDecimal offset = new BigDecimal("0"); // BigDecimal | 
    try {
      ContactListAnswerDto result = apiInstance.getContactsList(queryVatNumber, queryIsCustomer, queryIsProvider, sortFiscalName, sortVatNumber, sortUpdatedAt, sortCreatedAt, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContactsApi#getContactsList");
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
| **queryVatNumber** | **String**| Filter by exact VAT number | [optional] |
| **queryIsCustomer** | **Boolean**| Filter by customer flag | [optional] |
| **queryIsProvider** | **Boolean**| Filter by provider flag | [optional] |
| **sortFiscalName** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortVatNumber** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortUpdatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortCreatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **limit** | **BigDecimal**|  | [optional] [default to 10] |
| **offset** | **BigDecimal**|  | [optional] |

### Return type

[**ContactListAnswerDto**](ContactListAnswerDto.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **401** |  |  -  |
| **403** |  |  -  |

