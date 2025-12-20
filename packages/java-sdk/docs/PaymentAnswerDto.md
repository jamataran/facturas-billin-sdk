

# PaymentAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique ID of the payment |  |
|**createdAt** | **OffsetDateTime** | The date when the payment was created |  |
|**updatedAt** | **OffsetDateTime** | The date when the payment was last updated |  |
|**operationDate** | **OffsetDateTime** | The date when the payment was issued |  |
|**amount** | **BigDecimal** | Amount of the payment |  |
|**method** | [**MethodEnum**](#MethodEnum) | Method of the payment |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the payment. INCOME payments are payments that are received, and EXPENSE payments are payments that are made. |  |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the payment |  |
|**contact** | [**PaymentAnswerDtoContact**](PaymentAnswerDtoContact.md) |  |  |
|**documents** | [**List&lt;PaymentDocumentDto&gt;**](PaymentDocumentDto.md) | Documents that are related to the payment |  |
|**accountingAccount** | [**PaymentAnswerDtoAccountingAccount**](PaymentAnswerDtoAccountingAccount.md) |  |  [optional] |
|**description** | **String** | Description of the payment |  [optional] |
|**remittance** | [**PaymentAnswerDtoRemittance**](PaymentAnswerDtoRemittance.md) |  |  [optional] |



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


