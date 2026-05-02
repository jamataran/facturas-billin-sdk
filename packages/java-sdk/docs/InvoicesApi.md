# InvoicesApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createInvoice**](InvoicesApi.md#createInvoice) | **POST** /v1/invoices | Create an invoice |
| [**getInvoice**](InvoicesApi.md#getInvoice) | **GET** /v1/invoices/{id} | Get an invoice or a sales receipt |
| [**getInvoicesList**](InvoicesApi.md#getInvoicesList) | **GET** /v1/invoices | Get the invoices or sales receipts list |


<a id="createInvoice"></a>
# **createInvoice**
> InvoiceDocumentAnswerDto createInvoice(createInvoiceRequest)

Create an invoice

Endpoint to create an invoice

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.InvoicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    InvoicesApi apiInstance = new InvoicesApi(defaultClient);
    CreateInvoiceRequest createInvoiceRequest = new CreateInvoiceRequest(); // CreateInvoiceRequest | - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority.         - Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others.        - *Province* **is mandatory** for Spain country.
    try {
      InvoiceDocumentAnswerDto result = apiInstance.createInvoice(createInvoiceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvoicesApi#createInvoice");
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
| **createInvoiceRequest** | [**CreateInvoiceRequest**](CreateInvoiceRequest.md)| - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority.         - Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others.        - *Province* **is mandatory** for Spain country. | [optional] |

### Return type

[**InvoiceDocumentAnswerDto**](InvoiceDocumentAnswerDto.md)

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

<a id="getInvoice"></a>
# **getInvoice**
> GetInvoice200Response getInvoice(id)

Get an invoice or a sales receipt

Endpoint to get an invoice or a sales receipt

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.InvoicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    InvoicesApi apiInstance = new InvoicesApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      GetInvoice200Response result = apiInstance.getInvoice(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvoicesApi#getInvoice");
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
| **id** | **String**|  | |

### Return type

[**GetInvoice200Response**](GetInvoice200Response.md)

### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Depending on the type of the invoice the returned document can be a Sales Receipt or an Invoice |  -  |
| **400** | Some of the query params of the request are wrong |  -  |
| **401** |  |  -  |

<a id="getInvoicesList"></a>
# **getInvoicesList**
> GetInvoicesListAnswerDto getInvoicesList(queryDocumentType, queryStatus, queryIssuedDate, queryCreatedAt, queryUpdatedAt, querySerialCode, queryCode, queryIsPaid, queryContactVatNumber, queryReference, queryGetVerifactuInvoices, sortIssuedDate, sortCreatedAt, sortUpdatedAt, sortSerialCode, sortCode, sortReference, limit, offset)

Get the invoices or sales receipts list

Endpoint to get the invoices and sales receipts list   **Important limitation:**  Swagger UI does not correctly serialize nested query parameters with brackets when using the “Try it out” feature. As a result, requests built through the Swagger interface may not match the expected format and may return incorrect results.  To use advanced filters reliably, construct the URL manually or use an external HTTP client (Postman, Insomnia, curl, etc.).  The API fully supports bracket-based query syntax; this limitation applies only to Swagger UI presentation, not to the API behavior.

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.InvoicesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    InvoicesApi apiInstance = new InvoicesApi(defaultClient);
    List<String> queryDocumentType = Arrays.asList(); // List<String> | 
    List<String> queryStatus = Arrays.asList(); // List<String> | Allowed values:         - DRAFT         - ISSUED        - VOID        - CORRECTED: The invoice has been corrected with another invoice (a corrective invoice)        - REPLACED: The simplified invoice has been replaced with a standard invoice
    String queryIssuedDate = "queryIssuedDate_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01  Accepts ISO-8601 datetime
    String queryCreatedAt = "queryCreatedAt_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01  Accepts ISO-8601 datetime
    String queryUpdatedAt = "queryUpdatedAt_example"; // String | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01  Accepts ISO-8601 datetime
    String querySerialCode = "querySerialCode_example"; // String | 
    BigDecimal queryCode = new BigDecimal(78); // BigDecimal | 
    Boolean queryIsPaid = true; // Boolean | 
    String queryContactVatNumber = "queryContactVatNumber_example"; // String | 
    String queryReference = "queryReference_example"; // String | 
    Boolean queryGetVerifactuInvoices = true; // Boolean | When this parameter is not provided, or is false, only invoices prior to the Verifactu regulation are returned. If true, then only Verifactu type invoices are returned
    String sortIssuedDate = "ASC"; // String | 
    String sortCreatedAt = "ASC"; // String | 
    String sortUpdatedAt = "ASC"; // String | 
    String sortSerialCode = "ASC"; // String | 
    String sortCode = "ASC"; // String | 
    String sortReference = "ASC"; // String | 
    BigDecimal limit = new BigDecimal("10"); // BigDecimal | 
    BigDecimal offset = new BigDecimal("0"); // BigDecimal | 
    try {
      GetInvoicesListAnswerDto result = apiInstance.getInvoicesList(queryDocumentType, queryStatus, queryIssuedDate, queryCreatedAt, queryUpdatedAt, querySerialCode, queryCode, queryIsPaid, queryContactVatNumber, queryReference, queryGetVerifactuInvoices, sortIssuedDate, sortCreatedAt, sortUpdatedAt, sortSerialCode, sortCode, sortReference, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvoicesApi#getInvoicesList");
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
| **queryDocumentType** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: INVOICE, CORRECTIVE, TEST_INVOICE] |
| **queryStatus** | [**List&lt;String&gt;**](String.md)| Allowed values:         - DRAFT         - ISSUED        - VOID        - CORRECTED: The invoice has been corrected with another invoice (a corrective invoice)        - REPLACED: The simplified invoice has been replaced with a standard invoice | [optional] [enum: DRAFT, ISSUED, VOID, CORRECTED, REPLACED] |
| **queryIssuedDate** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01  Accepts ISO-8601 datetime | [optional] |
| **queryCreatedAt** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01  Accepts ISO-8601 datetime | [optional] |
| **queryUpdatedAt** | **String**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01  Accepts ISO-8601 datetime | [optional] |
| **querySerialCode** | **String**|  | [optional] |
| **queryCode** | **BigDecimal**|  | [optional] |
| **queryIsPaid** | **Boolean**|  | [optional] |
| **queryContactVatNumber** | **String**|  | [optional] |
| **queryReference** | **String**|  | [optional] |
| **queryGetVerifactuInvoices** | **Boolean**| When this parameter is not provided, or is false, only invoices prior to the Verifactu regulation are returned. If true, then only Verifactu type invoices are returned | [optional] |
| **sortIssuedDate** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortCreatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortUpdatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortSerialCode** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortCode** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortReference** | **String**|  | [optional] [enum: ASC, DESC] |
| **limit** | **BigDecimal**|  | [optional] [default to 10] |
| **offset** | **BigDecimal**|  | [optional] |

### Return type

[**GetInvoicesListAnswerDto**](GetInvoicesListAnswerDto.md)

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

