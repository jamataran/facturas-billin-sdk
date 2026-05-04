

# PaymentAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique ID of the payment |  [optional] |
|**createdAt** | **OffsetDateTime** | The date when the payment was created |  [optional] |
|**updatedAt** | **OffsetDateTime** | The date when the payment was last updated |  [optional] |
|**operationDate** | **OffsetDateTime** | The date when the payment was issued |  [optional] |
|**amount** | **BigDecimal** | Amount of the payment |  [optional] |
|**method** | [**MethodEnum**](#MethodEnum) | Method of the payment |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the payment. INCOME payments are payments that are received, and EXPENSE payments are payments that are made. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the payment |  [optional] |
|**contact** | [**PaymentAnswerDtoContact**](PaymentAnswerDtoContact.md) |  |  [optional] |
|**documents** | **List&lt;PaymentDocumentDto&gt;** | Documents that are related to the payment |  [optional] |
|**accountingAccount** | [**PaymentAnswerDtoAccountingAccount**](PaymentAnswerDtoAccountingAccount.md) |  |  [optional] |
|**description** | **String** | Description of the payment |  [optional] |
|**remittance** | [**PaymentAnswerDtoRemittance**](PaymentAnswerDtoRemittance.md) |  |  [optional] |
|**isReconciled** | **Boolean** | Whether the payment was created through bank transaction reconciliation |  [optional] |



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



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| LINKED | &quot;LINKED&quot; |
| NOT_LINKED | &quot;NOT_LINKED&quot; |
| PARTIALLY_LINKED | &quot;PARTIALLY_LINKED&quot; |


## Implemented Interfaces

* Serializable


