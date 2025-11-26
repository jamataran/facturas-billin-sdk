# # ExpenseDocumentAnswerDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **string** | The id of the document |
**created_at** | **\DateTime** | The date when the document was created |
**updated_at** | **\DateTime** | The date when the document was last updated |
**issued_date_time** | **\DateTime** | The datetime when the document was issued | [optional]
**issued_date** | **string** | The date when the document was issued | [optional]
**owner_info** | [**\FacturasBillin\SDK\Model\BusinessBaseAnswerDto**](BusinessBaseAnswerDto.md) | The owner of the document |
**currency** | **string** | Currency used on the document |
**comments** | **string** | Comments of the document | [optional]
**identifier** | **string** | The identifier of the document | [optional]
**contact** | [**\FacturasBillin\SDK\Model\DocumentContactAnswerDto**](DocumentContactAnswerDto.md) | Contact of the expense |
**lines** | [**\FacturasBillin\SDK\Model\DocumentLineAnswerDto[]**](DocumentLineAnswerDto.md) | Lines of the document |
**tax_lines** | [**\FacturasBillin\SDK\Model\DocumentTaxLineAnswerDto[]**](DocumentTaxLineAnswerDto.md) | Tax lines of the expense document |
**total** | [**\FacturasBillin\SDK\Model\DocumentTotalAnswerDto**](DocumentTotalAnswerDto.md) | The total of the document |
**retention_percentage** | **float** | Percentage of retention |
**retention_amount** | **float** | Retention amount |
**paid_amount** | **float** | Paid amount |
**is_paid** | **bool** | True if the document is paid | [optional]
**due_date** | **string** | The due date of the document | [optional]
**payment_methods** | [**\FacturasBillin\SDK\Model\GetPaymentMethodDto**](GetPaymentMethodDto.md) | Payment methods of the invoice |
**category** | **string** | Type of the document | [optional]
**is_expense** | **object** | Boolean indicating if the document is an expense |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
