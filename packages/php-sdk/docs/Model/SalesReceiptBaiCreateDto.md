# # SalesReceiptBaiCreateDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**serie_id** | **string** | The id of the serie. If provided together with serialCode, the serieId will be used | [optional]
**serial_code** | **string** | Serial Code of the document. If provided together with serieId, the serieId will be used | [optional]
**code** | **float** | Code/Number of the document | [optional]
**mask** | **float** | Mask used on the code of the document. The complete invoice identifier number is built from the serial code and the code. For example, for a serial code \&quot;F2023\&quot; and a code \&quot;1\&quot; the full identifier number that will appear in the PDF will be \&quot;F20231\&quot;. The mask allows for leading zeros to be included when constructing the complete ID number in the PDF. If we put a mask of 3, the full ID number will be \&quot;F2023001\&quot; | [optional]
**issued_date** | **string** | The date when the documen was issued | [optional]
**reference** | **string** | The reference of the document | [optional]
**visual_lines** | [**\FacturasBillin\SDK\Model\VisualLineDto[]**](VisualLineDto.md) | Visual Lines of the document | [optional]
**tax_lines** | [**\FacturasBillin\SDK\Model\DocumentTaxLineBaiDto[]**](DocumentTaxLineBaiDto.md) | Tax lines of the document. If not provided, they will be calculated from the lines | [optional]
**comments** | **string** | Comments of the document | [optional]
**currency** | **string** | Currency used on the document |
**total** | [**\FacturasBillin\SDK\Model\DocumentTotalDto**](DocumentTotalDto.md) | The total of the document. If not provided, it will be calculated from the lines and tax lines | [optional]
**is_paid** | **bool** | True if the document is paid. In the case of sending this value to true, a payment will be created with the same date and for the total value of the document. | [optional] [default to false]
**paid_amount** | **float** | Paid amount | [optional]
**retention_amount** | **float** | Amount of retention. If this property is set it will override retentionPercentage if it is also set | [optional]
**retention_percentage** | **float** | Percentage of retention | [optional]
**show_product_reference** | **bool** | True if product reference should be shown in Pdf | [optional] [default to false]
**operation_description** | **string** | The description of the operation | [optional]
**operation_date** | **string** | The date of the operation | [optional]
**tax_regime** | **string** | The tax regime of the operation | [optional]
**natural_person** | **bool** | (Bizkaia businesses) The counterparty is a natural person | [optional]
**epigraph_iae** | **string** | (Bizkaia businesses) IAE code in the Spanish Tax Office | [optional]
**charging_criterion_irpf** | **bool** | (Bizkaia businesses) True if your business activity is covered by the system whereby you can compute income and expenses at the time the services or products are actually received or paid for, even if the accrual has occurred at another time. | [optional]
**custom_irpf** | **float** | (Bizkaia businesses). If IRPF computed is different from VAT Tax Base, it is mandatory to indicate the value of Amount income IRPF. Required if chargingCriterionIRPF is true. | [optional]
**lines** | [**\FacturasBillin\SDK\Model\DocumentLineBaiDto[]**](DocumentLineBaiDto.md) | Lines of the document |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
