# AccountingAccountsApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAccountingAccount**](AccountingAccountsApi.md#createAccountingAccount) | **POST** /v1/accounting-accounts | Create an accounting account |
| [**getAccountingAccountList**](AccountingAccountsApi.md#getAccountingAccountList) | **GET** /v1/accounting-accounts | Get the accounting accounts list |


<a id="createAccountingAccount"></a>
# **createAccountingAccount**
> AccountingAccountAnswerDto createAccountingAccount(createAccountingAccountDto)

Create an accounting account

Endpoint to create an accounting account

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.AccountingAccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    AccountingAccountsApi apiInstance = new AccountingAccountsApi(defaultClient);
    CreateAccountingAccountDto createAccountingAccountDto = new CreateAccountingAccountDto(); // CreateAccountingAccountDto | There are are three types of accounting accounts. Each one of them expects a diferent payload:        - BANK_ACCOUNT: expects IBAN and SWIFT code.        - CREDIT_CARD: expects credit card number and expire date.        - CASH_REGISTER: expects no additional fields.
    try {
      AccountingAccountAnswerDto result = apiInstance.createAccountingAccount(createAccountingAccountDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountingAccountsApi#createAccountingAccount");
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
| **createAccountingAccountDto** | [**CreateAccountingAccountDto**](CreateAccountingAccountDto.md)| There are are three types of accounting accounts. Each one of them expects a diferent payload:        - BANK_ACCOUNT: expects IBAN and SWIFT code.        - CREDIT_CARD: expects credit card number and expire date.        - CASH_REGISTER: expects no additional fields. | [optional] |

### Return type

[**AccountingAccountAnswerDto**](AccountingAccountAnswerDto.md)

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

<a id="getAccountingAccountList"></a>
# **getAccountingAccountList**
> AccountingAccountListAnswerDto getAccountingAccountList(queryType, sortCreatedAt, sortUpdatedAt, sortAlias, limit, offset)

Get the accounting accounts list

Endpoint to get the accounting accounts list

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.AccountingAccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    AccountingAccountsApi apiInstance = new AccountingAccountsApi(defaultClient);
    String queryType = "BANK_ACCOUNT"; // String | 
    String sortCreatedAt = "ASC"; // String | 
    String sortUpdatedAt = "ASC"; // String | 
    String sortAlias = "ASC"; // String | 
    BigDecimal limit = new BigDecimal("10"); // BigDecimal | 
    BigDecimal offset = new BigDecimal("0"); // BigDecimal | 
    try {
      AccountingAccountListAnswerDto result = apiInstance.getAccountingAccountList(queryType, sortCreatedAt, sortUpdatedAt, sortAlias, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountingAccountsApi#getAccountingAccountList");
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
| **queryType** | **String**|  | [optional] [enum: BANK_ACCOUNT, CASH_REGISTER, CREDIT_CARD] |
| **sortCreatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortUpdatedAt** | **String**|  | [optional] [enum: ASC, DESC] |
| **sortAlias** | **String**|  | [optional] [enum: ASC, DESC] |
| **limit** | **BigDecimal**|  | [optional] [default to 10] |
| **offset** | **BigDecimal**|  | [optional] |

### Return type

[**AccountingAccountListAnswerDto**](AccountingAccountListAnswerDto.md)

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

