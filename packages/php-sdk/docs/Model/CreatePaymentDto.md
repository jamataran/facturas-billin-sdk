# # CreatePaymentDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operation_date** | **string** | Date of the payment |
**amount** | **float** | Amount of the payment |
**method** | **string** | Method of the payment | [optional]
**type** | **string** | Type of the payment. INCOME payments are payments that are received, and EXPENSE payments are payments that are made. |
**contact_id** | **string** | Id of the contact that is related to the payment. If this field is filled, the documentsIds field must be empty. If this field is empty, the documentsIds field must be filled. | [optional]
**documents_ids** | **string[]** | Ids of the documents that are related to the payment. If this field is filled, the contactId field must be empty. If this field is empty, the contactId field must be filled. | [optional]
**accounting_account_id** | **string** | Id of the accounting account that is related to the payment. | [optional]
**description** | **string** | Description of the payment | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
