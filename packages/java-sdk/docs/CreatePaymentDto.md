

# CreatePaymentDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**operationDate** | **String** | Date of the payment |  [optional] |
|**amount** | **BigDecimal** | Amount of the payment |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | Method of the payment |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the payment. INCOME payments are payments that are received, and EXPENSE payments are payments that are made. |  [optional] |
|**contactId** | **String** | Id of the contact that is related to the payment. If this field is filled, the documentsIds field must be empty. If this field is empty, the documentsIds field must be filled. |  [optional] |
|**documentsIds** | **List&lt;String&gt;** | Ids of the documents that are related to the payment. If this field is filled, the contactId field must be empty. If this field is empty, the contactId field must be filled. |  [optional] |
|**accountingAccountId** | **String** | Id of the accounting account that is related to the payment. |  [optional] |
|**description** | **String** | Description of the payment |  [optional] |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| BIZUM | &quot;BIZUM&quot; |
| CASH | &quot;CASH&quot; |
| CREDIT_CARD | &quot;CREDIT_CARD&quot; |
| DIRECT_DEBIT | &quot;DIRECT_DEBIT&quot; |
| PROMISSORY_NOTE | &quot;PROMISSORY_NOTE&quot; |
| TRANSFER | &quot;TRANSFER&quot; |
| OTHER | &quot;OTHER&quot; |
| CONFIRMING | &quot;CONFIRMING&quot; |
| NOT_CONFIRMED | &quot;NOT_CONFIRMED&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| INCOME | &quot;INCOME&quot; |
| EXPENSE | &quot;EXPENSE&quot; |


## Implemented Interfaces

* Serializable


