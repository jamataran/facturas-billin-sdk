# PaymentsApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPayment**](PaymentsApi.md#createPayment) | **POST** /v1/payments | Create a payment |
| [**getPaymentList**](PaymentsApi.md#getPaymentList) | **GET** /v1/payments | Get payment list |


<a id="createPayment"></a>
# **createPayment**
> PaymentAnswerDto createPayment(createPaymentDto)

Create a payment

Endpoint to create a payment

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    PaymentsApi apiInstance = new PaymentsApi(defaultClient);
    CreatePaymentDto createPaymentDto = new CreatePaymentDto(); // CreatePaymentDto | - There are two fields to set the **contact**, either by filling in the ***contactId*** field or the ***documentsId*** field. You can't send both, please provide **only one of them**.
    try {
      PaymentAnswerDto result = apiInstance.createPayment(createPaymentDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#createPayment");
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
| **createPaymentDto** | [**CreatePaymentDto**](CreatePaymentDto.md)| - There are two fields to set the **contact**, either by filling in the ***contactId*** field or the ***documentsId*** field. You can&#39;t send both, please provide **only one of them**. | [optional] |

### Return type

[**PaymentAnswerDto**](PaymentAnswerDto.md)

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

<a id="getPaymentList"></a>
# **getPaymentList**
> PaymentListAnswerDto getPaymentList(sortCreatedAt, sortOperationDate, queryType, queryMethod, queryOperationDate, queryContactId, queryAccountingAccountId, limit, offset)

Get payment list

Endpoint to get the payment list

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.PaymentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    PaymentsApi apiInstance = new PaymentsApi(defaultClient);
    String sortCreatedAt = "ASC"; // String | 
    String sortOperationDate = "ASC"; // String | 
    String queryType = "INCOME"; // String | 
    String queryMethod = "BIZUM"; // String | 
    String queryOperationDate = "queryOperationDate_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
    String queryContactId = "queryContactId_example"; // String | The contact id of the payment
    String queryAccountingAccountId = "queryAccountingAccountId_example"; // String | The accounting account id of the payment
    BigDecimal limit = new BigDecimal("10"); // BigDecimal | 
    BigDecimal offset = new BigDecimal("0"); // BigDecimal | 
    try {
      PaymentListAnswerDto result = apiInstance.getPaymentList(sortCreatedAt, sortOperationDate, queryType, queryMethod, queryOperationDate, queryContactId, queryAccountingAccountId, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentsApi#getPaymentList");
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
| **sortCreatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortOperationDate** | **String**|  | [optional] [enum: ASC, DESC] |
| **queryType** | **String**|  | [optional] [enum: INCOME, EXPENSE] |
| **queryMethod** | **String**|  | [optional] [enum: BIZUM, CASH, CREDIT_CARD, DIRECT_DEBIT, PROMISSORY_NOTE, TRANSFER, OTHER, CONFIRMING, NOT_CONFIRMED] |
| **queryOperationDate** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **queryContactId** | **String**| The contact id of the payment | [optional] |
| **queryAccountingAccountId** | **String**| The accounting account id of the payment | [optional] |
| **limit** | **BigDecimal**|  | [optional] [default to 10] |
| **offset** | **BigDecimal**|  | [optional] |

### Return type

[**PaymentListAnswerDto**](PaymentListAnswerDto.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **401** |  |  -  |

