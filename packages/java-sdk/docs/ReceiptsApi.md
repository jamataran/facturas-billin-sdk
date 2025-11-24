# ReceiptsApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createReceipt**](ReceiptsApi.md#createReceipt) | **POST** /v1/invoices/sales-receipts | Create a receipt |


<a id="createReceipt"></a>
# **createReceipt**
> SalesReceiptDocumentAnswerDto createReceipt(createReceiptRequest)

Create a receipt

Endpoint to create a receipt

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.ReceiptsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    ReceiptsApi apiInstance = new ReceiptsApi(defaultClient);
    CreateReceiptRequest createReceiptRequest = new CreateReceiptRequest(); // CreateReceiptRequest | If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others
    try {
      SalesReceiptDocumentAnswerDto result = apiInstance.createReceipt(createReceiptRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReceiptsApi#createReceipt");
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
| **createReceiptRequest** | [**CreateReceiptRequest**](CreateReceiptRequest.md)| If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others | [optional] |

### Return type

[**SalesReceiptDocumentAnswerDto**](SalesReceiptDocumentAnswerDto.md)

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

