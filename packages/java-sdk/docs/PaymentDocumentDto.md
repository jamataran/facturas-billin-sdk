

# PaymentDocumentDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique ID of the document that is related to the payment |  [optional] |
|**identifier** | **String** | Identifier of the document that is related to the payment |  [optional] |
|**receiptStatus** | [**ReceiptStatusEnum**](#ReceiptStatusEnum) | Indicates if the document is a receipt or not |  [optional] |
|**issuedDate** | **String** | The date when the documen was issued |  [optional] |



## Enum: ReceiptStatusEnum

| Name | Value |
|---- | -----|
| IS_RECEIPT | &quot;IS_RECEIPT&quot; |
| WAS_RECEIPT | &quot;WAS_RECEIPT&quot; |


## Implemented Interfaces

* Serializable


