# # AccountingAccountAnswerDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** | Unique ID of the accounting account |
**created_at** | **\DateTime** | The date when the accounting account was created |
**updated_at** | **\DateTime** | The date when the accounting account was last updated |
**type** | **string** | Type of the accounting account: bank account, credit card or cash register |
**alias** | **string** | Name given by the user to be able to identify the account |
**iban** | **string** | IBAN of the accounting account in case it has the bank account type | [optional]
**swift_code** | **string** | SWIFT code of the accounting account in case it has the bank account type | [optional]
**credit_card_number** | **string** | Credit card number of the accounting account in case it has the credit card type | [optional]
**credit_card_expire_date** | **string** | Expiration date of the credit card in case it has the credit card type | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
