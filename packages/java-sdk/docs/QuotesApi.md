# QuotesApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createQuote**](QuotesApi.md#createQuote) | **POST** /v1/quotes | Create a quote |


<a id="createQuote"></a>
# **createQuote**
> QuoteDocumentAnswerDto createQuote(quoteCreateDto)

Create a quote

Endpoint to create a quote

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.QuotesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    QuotesApi apiInstance = new QuotesApi(defaultClient);
    QuoteCreateDto quoteCreateDto = new QuoteCreateDto(); // QuoteCreateDto | - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority.
    try {
      QuoteDocumentAnswerDto result = apiInstance.createQuote(quoteCreateDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling QuotesApi#createQuote");
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
| **quoteCreateDto** | [**QuoteCreateDto**](QuoteCreateDto.md)| - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority. | [optional] |

### Return type

[**QuoteDocumentAnswerDto**](QuoteDocumentAnswerDto.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |
| **400** | Some of the params of the request are wrong |  -  |
| **401** |  |  -  |

