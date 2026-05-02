

# AccountingAccountAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique ID of the accounting account |  |
|**createdAt** | **OffsetDateTime** | The date when the accounting account was created |  |
|**updatedAt** | **OffsetDateTime** | The date when the accounting account was last updated |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the accounting account: bank account, credit card or cash register |  |
|**alias** | **String** | Name given by the user to be able to identify the account |  |
|**IBAN** | **String** | IBAN of the accounting account in case it has the bank account type |  [optional] |
|**swiftCode** | **String** | SWIFT code of the accounting account in case it has the bank account type |  [optional] |
|**creditCardNumber** | **String** | Credit card number of the accounting account in case it has the credit card type |  [optional] |
|**creditCardExpireDate** | **String** | Expiration date of the credit card in case it has the credit card type |  [optional] |
|**isAutomaticConnected** | **Boolean** | Whether the account is automatically connected (true) or manual (false) |  |
|**lastSync** | **String** | Date and time of the last sync (ISO 8601) |  [optional] |
|**pendingReconciliationCount** | **BigDecimal** | Count of imported transactions pending reconciliation |  [optional] |
|**bankName** | **String** | Bank name |  [optional] |
|**balance** | **BigDecimal** | Current balance |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BANK_ACCOUNT | &quot;BANK_ACCOUNT&quot; |
| CASH_REGISTER | &quot;CASH_REGISTER&quot; |
| CREDIT_CARD | &quot;CREDIT_CARD&quot; |


## Implemented Interfaces

* Serializable


