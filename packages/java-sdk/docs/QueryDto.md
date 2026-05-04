

# QueryDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**documentType** | [**List&lt;DocumentTypeEnum&gt;**](#List&lt;DocumentTypeEnum&gt;) |  |  [optional] |
|**status** | [**List&lt;StatusEnum&gt;**](#List&lt;StatusEnum&gt;) | Allowed values:         - DRAFT         - ISSUED        - VOID        - CORRECTED: The invoice has been corrected with another invoice (a corrective invoice)        - REPLACED: The simplified invoice has been replaced with a standard invoice |  [optional] |
|**issuedDate** | **String** | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01  Accepts ISO-8601 datetime |  [optional] |
|**createdAt** | **String** | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01  Accepts ISO-8601 datetime |  [optional] |
|**updatedAt** | **String** | You can filter by a date range using one of the following operators:  - $gt: greater than  - $gte: greater than or equal  - $lt: lower than  - $lte: lower than or equal  - ⚠️ Swagger UI cannot serialize these parameters correctly; build the query manually when using these operators.  Example: query[date][$gt]&#x3D;2023-01-01&amp;query[date][$lt]&#x3D;2023-02-01  Accepts ISO-8601 datetime |  [optional] |
|**serialCode** | **String** |  |  [optional] |
|**code** | **BigDecimal** |  |  [optional] |
|**isPaid** | **Boolean** |  |  [optional] |
|**contact** | **ContactDto** |  |  [optional] |
|**reference** | **String** |  |  [optional] |
|**getVerifactuInvoices** | **Boolean** | When this parameter is not provided, or is false, only invoices prior to the Verifactu regulation are returned. If true, then only Verifactu type invoices are returned |  [optional] |



## Enum: List&lt;DocumentTypeEnum&gt;

| Name | Value |
|---- | -----|
| INVOICE | &quot;INVOICE&quot; |
| CORRECTIVE | &quot;CORRECTIVE&quot; |
| TEST_INVOICE | &quot;TEST_INVOICE&quot; |



## Enum: List&lt;StatusEnum&gt;

| Name | Value |
|---- | -----|
| DRAFT | &quot;DRAFT&quot; |
| ISSUED | &quot;ISSUED&quot; |
| VOID | &quot;VOID&quot; |
| CORRECTED | &quot;CORRECTED&quot; |
| REPLACED | &quot;REPLACED&quot; |


## Implemented Interfaces

* Serializable


