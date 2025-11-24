# ProductsApi

All URIs are relative to *https://api.billin.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createProduct**](ProductsApi.md#createProduct) | **POST** /v1/products | Create a product |


<a id="createProduct"></a>
# **createProduct**
> ProductAnswerDto createProduct(createProductDto)

Create a product

Endpoint to create a product

### Example
```java
// Import classes:
import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.ApiException;
import net.facturasbillin.sdk.Configuration;
import net.facturasbillin.sdk.auth.*;
import net.facturasbillin.sdk.models.*;
import net.facturasbillin.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.billin.net");
    
    // Configure HTTP bearer authorization: bearer
    HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
    bearer.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    CreateProductDto createProductDto = new CreateProductDto(); // CreateProductDto | - At least one of the two fields *sellingPrice* or *retailPrice* is mandatory.
    try {
      ProductAnswerDto result = apiInstance.createProduct(createProductDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#createProduct");
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
| **createProductDto** | [**CreateProductDto**](CreateProductDto.md)| - At least one of the two fields *sellingPrice* or *retailPrice* is mandatory. | [optional] |

### Return type

[**ProductAnswerDto**](ProductAnswerDto.md)

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

