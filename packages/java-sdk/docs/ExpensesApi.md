# ExpensesApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createExpense**](ExpensesApi.md#createExpense) | **POST** /v1/expenses | Create an expense |
| [**getExpensesList**](ExpensesApi.md#getExpensesList) | **GET** /v1/expenses | Get the expenses list |


<a id="createExpense"></a>
# **createExpense**
> ExpenseDocumentAnswerDto createExpense(expenseCreateDto)

Create an expense

Endpoint to create an expense

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.ExpensesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    ExpensesApi apiInstance = new ExpensesApi(defaultClient);
    ExpenseCreateDto expenseCreateDto = new ExpenseCreateDto(); // ExpenseCreateDto | - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - *Province* **is mandatory** for Spain country.
    try {
      ExpenseDocumentAnswerDto result = apiInstance.createExpense(expenseCreateDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExpensesApi#createExpense");
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
| **expenseCreateDto** | [**ExpenseCreateDto**](ExpenseCreateDto.md)| - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - *Province* **is mandatory** for Spain country. | [optional] |

### Return type

[**ExpenseDocumentAnswerDto**](ExpenseDocumentAnswerDto.md)

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

<a id="getExpensesList"></a>
# **getExpensesList**
> GetExpenseListAnswerDto getExpensesList(queryIssuedDate, queryCreatedAt, queryUpdatedAt, queryIdentifier, queryIsPaid, queryContactVatNumber, sortIssuedDate, sortCreatedAt, sortUpdatedAt, sortIdentifier, limit, offset)

Get the expenses list

Endpoint to get the expenses list

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.ExpensesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    ExpensesApi apiInstance = new ExpensesApi(defaultClient);
    String queryIssuedDate = "queryIssuedDate_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
    String queryCreatedAt = "queryCreatedAt_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
    String queryUpdatedAt = "queryUpdatedAt_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
    String queryIdentifier = "queryIdentifier_example"; // String | 
    Boolean queryIsPaid = true; // Boolean | 
    String queryContactVatNumber = "queryContactVatNumber_example"; // String | 
    String sortIssuedDate = "ASC"; // String | 
    String sortCreatedAt = "ASC"; // String | 
    String sortUpdatedAt = "ASC"; // String | 
    String sortIdentifier = "ASC"; // String | 
    BigDecimal limit = new BigDecimal("10"); // BigDecimal | 
    BigDecimal offset = new BigDecimal("0"); // BigDecimal | 
    try {
      GetExpenseListAnswerDto result = apiInstance.getExpensesList(queryIssuedDate, queryCreatedAt, queryUpdatedAt, queryIdentifier, queryIsPaid, queryContactVatNumber, sortIssuedDate, sortCreatedAt, sortUpdatedAt, sortIdentifier, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExpensesApi#getExpensesList");
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
| **queryIssuedDate** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **queryCreatedAt** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **queryUpdatedAt** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **queryIdentifier** | **String**|  | [optional] |
| **queryIsPaid** | **Boolean**|  | [optional] |
| **queryContactVatNumber** | **String**|  | [optional] |
| **sortIssuedDate** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortCreatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortUpdatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortIdentifier** | **String**|  | [optional] [enum: ASC, DESC] |
| **limit** | **BigDecimal**|  | [optional] [default to 10] |
| **offset** | **BigDecimal**|  | [optional] |

### Return type

[**GetExpenseListAnswerDto**](GetExpenseListAnswerDto.md)

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

