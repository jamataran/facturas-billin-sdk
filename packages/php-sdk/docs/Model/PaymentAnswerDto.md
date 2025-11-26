# # PaymentAnswerDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** | Unique ID of the payment |
**created_at** | **\DateTime** | The date when the payment was created |
**updated_at** | **\DateTime** | The date when the payment was last updated |
**operation_date** | **\DateTime** | The date when the payment was issued |
**amount** | **float** | Amount of the payment |
**method** | **string** | Method of the payment |
**type** | **string** | Type of the payment. INCOME payments are payments that are received, and EXPENSE payments are payments that are made. |
**status** | **string** | Status of the payment |
**contact** | [**\FacturasBillin\SDK\Model\ContactPaymentDto**](ContactPaymentDto.md) | Contact that is related to the payment |
**documents** | [**\FacturasBillin\SDK\Model\PaymentDocumentDto[]**](PaymentDocumentDto.md) | Documents that are related to the payment |
**accounting_account** | [**\FacturasBillin\SDK\Model\AccountingAccountDto**](AccountingAccountDto.md) | Accounting account that is related to the payment |
**description** | **string** | Description of the payment | [optional]
**remittance** | [**\FacturasBillin\SDK\Model\RemittanceDto**](RemittanceDto.md) | Remittance that is related to the payment |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
