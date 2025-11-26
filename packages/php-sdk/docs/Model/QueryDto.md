# # QueryDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**document_type** | **string[]** |  | [optional]
**status** | **string[]** | Allowed values:         - DRAFT         - ISSUED        - VOID        - CORRECTED: The invoice has been corrected with another invoice (a corrective invoice)        - REPLACED: The simplified invoice has been replaced with a standard invoice | [optional]
**issued_date** | **string** | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional]
**created_at** | **string** | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional]
**updated_at** | **string** | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01 | [optional]
**serial_code** | **string** |  | [optional]
**code** | **float** |  | [optional]
**is_paid** | **bool** |  | [optional]
**contact** | [**\FacturasBillin\SDK\Model\ContactDto**](ContactDto.md) |  | [optional]
**reference** | **string** |  | [optional]
**get_verifactu_invoices** | **bool** | When this parameter is not provided, or is false, only invoices prior to the Verifactu regulation are returned. If true, then only Verifactu type invoices are returned | [optional] [default to false]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
