# FacturasBillin\SDK\InvoicesApi

All URIs are relative to https://api.billin.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createInvoice()**](InvoicesApi.md#createInvoice) | **POST** /v1/invoices | Create an invoice |
| [**getInvoice()**](InvoicesApi.md#getInvoice) | **GET** /v1/invoices/{id} | Get an invoice or a sales receipt |
| [**getInvoicesList()**](InvoicesApi.md#getInvoicesList) | **GET** /v1/invoices | Get the invoices or sales receipts list |


## `createInvoice()`

```php
createInvoice($invoice_create_dto): \FacturasBillin\SDK\Model\InvoiceDocumentAnswerDto
```

Create an invoice

Endpoint to create an invoice

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\InvoicesApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$invoice_create_dto = {"currency":"EUR","lines":[{"name":"Product name","quantity":2,"unitPrice":10,"totalAmount":21.78,"discountAmount":2,"taxKey":"IVA_21","taxAmount":3.78,"salesEqTaxAmount":0}],"contact":{"fiscalName":"Contact S.L."}}; // \FacturasBillin\SDK\Model\InvoiceCreateDto | - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority.         - Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others.        - *Province* **is mandatory** for Spain country.

try {
    $result = $apiInstance->createInvoice($invoice_create_dto);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling InvoicesApi->createInvoice: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **invoice_create_dto** | [**\FacturasBillin\SDK\Model\InvoiceCreateDto**](../Model/InvoiceCreateDto.md)| - If you only send the *lines* field, Billin will **calculate the totals**. If, on the other hand, you want to send all the values so that Billin **does not calculate anything**, you must send the fields *taxLines* and *total*.        - There are two fields to send the **serial number**, either by filling in the *serialCode* field or the *serialId* field. In case of sending both, the serialId field has priority.         - Depending on where you have your tax domicile (Basque Country or the rest of Spain) you will have to send some data or others.        - *Province* **is mandatory** for Spain country. | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\InvoiceDocumentAnswerDto**](../Model/InvoiceDocumentAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getInvoice()`

```php
getInvoice($id): \FacturasBillin\SDK\Model\GetInvoice200Response
```

Get an invoice or a sales receipt

Endpoint to get an invoice or a sales receipt

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\InvoicesApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = 'id_example'; // string

try {
    $result = $apiInstance->getInvoice($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling InvoicesApi->getInvoice: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **string**|  | |

### Return type

[**\FacturasBillin\SDK\Model\GetInvoice200Response**](../Model/GetInvoice200Response.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getInvoicesList()`

```php
getInvoicesList($query_document_type, $query_status, $query_issued_date, $query_created_at, $query_updated_at, $query_serial_code, $query_code, $query_is_paid, $query_contact_vat_number, $query_reference, $query_get_verifactu_invoices, $sort_issued_date, $sort_created_at, $sort_updated_at, $sort_serial_code, $sort_code, $sort_reference, $limit, $offset): \FacturasBillin\SDK\Model\GetInvoicesListAnswerDto
```

Get the invoices or sales receipts list

Endpoint to get the invoices and sales receipts list

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure Bearer (JWT) authorization: bearer
$config = FacturasBillin\SDK\Configuration::getDefaultConfiguration()->setAccessToken('YOUR_ACCESS_TOKEN');


$apiInstance = new FacturasBillin\SDK\Api\InvoicesApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$query_document_type = ["INVOICE","CORRECTIVE"]; // string[]
$query_status = ["ISSUED"]; // string[] | Allowed values:         - DRAFT         - ISSUED        - VOID        - CORRECTED: The invoice has been corrected with another invoice (a corrective invoice)        - REPLACED: The simplified invoice has been replaced with a standard invoice
$query_issued_date = 'query_issued_date_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_created_at = 'query_created_at_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_updated_at = 'query_updated_at_example'; // string | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]=2023-01-01&query[date][$lt]=2023-02-01
$query_serial_code = 'query_serial_code_example'; // string
$query_code = 3.4; // float
$query_is_paid = True; // bool
$query_contact_vat_number = 'query_contact_vat_number_example'; // string
$query_reference = 'query_reference_example'; // string
$query_get_verifactu_invoices = True; // bool | When this parameter is not provided, or is false, only invoices prior to the Verifactu regulation are returned. If true, then only Verifactu type invoices are returned
$sort_issued_date = 'sort_issued_date_example'; // string
$sort_created_at = 'sort_created_at_example'; // string
$sort_updated_at = 'sort_updated_at_example'; // string
$sort_serial_code = 'sort_serial_code_example'; // string
$sort_code = 'sort_code_example'; // string
$sort_reference = 'sort_reference_example'; // string
$limit = 10; // float
$offset = 0; // float

try {
    $result = $apiInstance->getInvoicesList($query_document_type, $query_status, $query_issued_date, $query_created_at, $query_updated_at, $query_serial_code, $query_code, $query_is_paid, $query_contact_vat_number, $query_reference, $query_get_verifactu_invoices, $sort_issued_date, $sort_created_at, $sort_updated_at, $sort_serial_code, $sort_code, $sort_reference, $limit, $offset);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling InvoicesApi->getInvoicesList: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **query_document_type** | [**string[]**](../Model/string.md)|  | [optional] |
| **query_status** | [**string[]**](../Model/string.md)| Allowed values:         - DRAFT         - ISSUED        - VOID        - CORRECTED: The invoice has been corrected with another invoice (a corrective invoice)        - REPLACED: The simplified invoice has been replaced with a standard invoice | [optional] |
| **query_issued_date** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_created_at** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_updated_at** | **string**| You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional] |
| **query_serial_code** | **string**|  | [optional] |
| **query_code** | **float**|  | [optional] |
| **query_is_paid** | **bool**|  | [optional] |
| **query_contact_vat_number** | **string**|  | [optional] |
| **query_reference** | **string**|  | [optional] |
| **query_get_verifactu_invoices** | **bool**| When this parameter is not provided, or is false, only invoices prior to the Verifactu regulation are returned. If true, then only Verifactu type invoices are returned | [optional] |
| **sort_issued_date** | **string**|  | [optional] |
| **sort_created_at** | **string**|  | [optional] |
| **sort_updated_at** | **string**|  | [optional] |
| **sort_serial_code** | **string**|  | [optional] |
| **sort_code** | **string**|  | [optional] |
| **sort_reference** | **string**|  | [optional] |
| **limit** | **float**|  | [optional] [default to 10] |
| **offset** | **float**|  | [optional] |

### Return type

[**\FacturasBillin\SDK\Model\GetInvoicesListAnswerDto**](../Model/GetInvoicesListAnswerDto.md)

### Authorization

[bearer](../../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
