

# AccountingAccountDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique ID of the accounting account that is related to the payment |  [optional] |
|**alias** | **String** | Alias of the accounting account that is related to the payment |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the accounting account: bank account, credit card or cash register |  [optional] |
|**IBAN** | **String** | IBAN of the accounting account in case it has the bank account type |  [optional] |
|**swiftCode** | **String** | SWIFT code of the accounting account in case it has the bank account type |  [optional] |
|**creditCardNumber** | **String** | Credit card number of the accounting account in case it has the credit card type |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| BANK_ACCOUNT | &quot;BANK_ACCOUNT&quot; |
| CASH_REGISTER | &quot;CASH_REGISTER&quot; |
| CREDIT_CARD | &quot;CREDIT_CARD&quot; |


## Implemented Interfaces

* Serializable


