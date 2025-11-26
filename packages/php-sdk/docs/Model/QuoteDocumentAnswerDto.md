# # QuoteDocumentAnswerDto

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
**serie_id** | **string** | The id of the serie | [optional]
**serial_code** | **string** | Serial Code of the document | [optional]
**mask** | **float** | Mask used on the code of the document. The complete invoice identifier number is built from the serial code and the code. For example, for a serial code \&quot;F2023\&quot; and a code \&quot;1\&quot; the full identifier number that will appear in the PDF will be \&quot;F20231\&quot;. The mask allows for leading zeros to be included when constructing the complete ID number in the PDF. If we put a mask of 3, the full ID number will be \&quot;F2023001\&quot; | [optional]
**code** | **float** | Code/Number of the document | [optional]
**identifier** | **string** | The identifier of the document | [optional]
**due_date** | **string** | The due date of the document |
**reference** | **string** | The reference of the document | [optional]
**total** | [**\FacturasBillin\SDK\Model\DocumentTotalAnswerDto**](DocumentTotalAnswerDto.md) | The total of the quote |
**lines** | [**\FacturasBillin\SDK\Model\DocumentLineAnswerDto[]**](DocumentLineAnswerDto.md) | Lines of the quote |
**visual_lines** | [**\FacturasBillin\SDK\Model\VisualLineDto[]**](VisualLineDto.md) | Visual Lines of the document |
**tax_lines** | [**\FacturasBillin\SDK\Model\DocumentTaxLineAnswerDto[]**](DocumentTaxLineAnswerDto.md) | Tax lines of the quote |
**additional_expenses** | [**\FacturasBillin\SDK\Model\AdditionalExpenseAnswerDto**](AdditionalExpenseAnswerDto.md) | Additional expenses of the quote |
**retention_percentage** | **float** | Percentage of retention |
**retention_amount** | **float** | Retention amount |
**paid_amount** | **float** | Paid amount |
**document_type** | **string** | Type of the document | [optional]
**category** | **string** | Type of the document | [optional]
**contact** | [**\FacturasBillin\SDK\Model\DocumentContactAnswerDto**](DocumentContactAnswerDto.md) | Contact of the quote |
**payment_methods** | [**\FacturasBillin\SDK\Model\GetPaymentMethodDto**](GetPaymentMethodDto.md) | Payment methods of the quote |
**status** | **string** | Status of the quote |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
