# # ExpenseCreateDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**visual_lines** | [**\FacturasBillin\SDK\Model\VisualLineDto[]**](VisualLineDto.md) | Visual Lines of the document | [optional]
**comments** | **string** | Comments of the document | [optional]
**currency** | **string** | Currency used on the document |
**is_paid** | **bool** | True if the document is paid. In the case of sending this value to true, a payment will be created with the same date and for the total value of the document. | [optional] [default to false]
**retention_amount** | **float** | Amount of retention. If this property is set it will override retentionPercentage if it is also set | [optional]
**retention_percentage** | **float** | Percentage of retention | [optional]
**identifier** | **string** | Invoice number |
**issued_date** | **string** | The date when the documen was issued |
**due_date** | **string** | Due date of the document | [optional]
**lines** | [**\FacturasBillin\SDK\Model\ExpenseLineBaseDto[]**](ExpenseLineBaseDto.md) | Lines of the expense |
**tax_lines** | [**\FacturasBillin\SDK\Model\ExpenseTaxLineBaseDto[]**](ExpenseTaxLineBaseDto.md) | Tax lines of the expense. If not provided, they will be calculated from the lines | [optional]
**total** | [**\FacturasBillin\SDK\Model\ExpenseTotalDto**](ExpenseTotalDto.md) | The total of the expense. If not provided, it will be calculated from the lines and tax lines | [optional]
**category** | **string** | Type of the document | [optional]
**contact** | [**\FacturasBillin\SDK\Model\DocumentContactDto**](DocumentContactDto.md) | Contact of the document |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
