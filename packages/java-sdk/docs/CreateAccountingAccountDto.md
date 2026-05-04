

# CreateAccountingAccountDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Type of the accounting account: bank account, credit card or cash register |  [optional] |
|**alias** | **String** | Name given by the user to be able to identify the account |  [optional] |
|**IBAN** | **String** | IBAN of the accounting account in case it has the bank account type |  [optional] |
|**swiftCode** | **String** | SWIFT code of the accounting account in case it has the bank account type |  [optional] |
|**creditCardNumber** | **String** | Last 4 digits of a credit card number of the accounting account in case it has the credit card type |  [optional] |
|**creditCardExpireDate** | **String** | Expiration date of the credit card in case it has the credit card type |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BANK_ACCOUNT | &quot;BANK_ACCOUNT&quot; |
| CASH_REGISTER | &quot;CASH_REGISTER&quot; |
| CREDIT_CARD | &quot;CREDIT_CARD&quot; |


## Implemented Interfaces

* Serializable


