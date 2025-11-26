# # InvoiceDocumentAnswerDto

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
**total** | [**\FacturasBillin\SDK\Model\DocumentTotalAnswerDto**](DocumentTotalAnswerDto.md) | The total of the document |
**lines** | [**\FacturasBillin\SDK\Model\DocumentLineAnswerDto[]**](DocumentLineAnswerDto.md) | Lines of the document |
**visual_lines** | [**\FacturasBillin\SDK\Model\VisualLineDto[]**](VisualLineDto.md) | Visual Lines of the document |
**tax_lines** | [**\FacturasBillin\SDK\Model\DocumentTaxLineAnswerDto[]**](DocumentTaxLineAnswerDto.md) | Tax lines of the document |
**additional_expenses** | [**\FacturasBillin\SDK\Model\AdditionalExpenseAnswerDto**](AdditionalExpenseAnswerDto.md) | Additional expenses of the invoice |
**retention_percentage** | **float** | Percentage of retention |
**retention_amount** | **float** | Retention amount |
**paid_amount** | **float** | Paid amount |
**is_paid** | **bool** | True if the document is paid | [optional]
**document_type** | **string** | Type of the document | [optional]
**category** | **string** | Type of the document | [optional]
**operation_description** | **string** | The description of the operation | [optional]
**operation_date** | **string** | The date of the operation | [optional]
**tax_regime** | **string** | Is the Vat Taxation Key that is applied in issuing an invoice. You can consult the differents VAT Taxation Systems on the [Tax Agency page](https://sede.agenciatributaria.gob.es/Sede/iva/regimenes-tributacion-iva.html). | [optional]
**natural_person** | **bool** | (Bizkaia Business only) Mark this value as true if the Invoice Issuer is a natural person. | [optional]
**epigraph_iae** | **string** | For Bizkaia Business only. The IAE (Tax on Economic Activities) is a section that determines the economic activity you carry out. This activity is made up of sections and groups that include business or professional activities represented by a code. You can find the differents IAE sections on the [Tax Agency Activity finder](https://www2.agenciatributaria.gob.es/static_files/common/internet/html/buscadorCensal_v2.html?callback&#x3D;recogerValorIAE&amp;idConv&#x3D;202307131145596872521) | [optional]
**charging_criterion_irpf** | **bool** | (Bizkaia businesses) True if your business activity is covered by the system whereby you can compute income and expenses at the time the services or products are actually received or paid for, even if the accrual has occurred at another time. | [optional]
**custom_irpf** | **float** | (Bizkaia businesses). If IRPF computed is different from VAT Tax Base, it is mandatory to indicate the value of Amount income IRPF. Required if chargingCriterionIRPF is true. | [optional]
**tax_authority_status** | **string** | Invoice status reported by the tax authority | [optional]
**tax_authority_code** | **string** | Ticket BAI identifier | [optional]
**qr** | **string** | QR code | [optional]
**tax_authority_validations** | [**\FacturasBillin\SDK\Model\TaxAuthorityErrorDto[]**](TaxAuthorityErrorDto.md) | Error list returned by the tax authority | [optional]
**is_receipt** | **bool** | Boolean indicating if the document is a receipt |
**status** | **string** | DRAFT -&gt; The prior stage of an invoice that is saved to complete at a later time.&lt;br&gt;ISSUED -&gt; It’s an oficial document that records the products or services delivered to the customer, the total amount due, and the preferred payment method.&lt;br&gt;VOID -&gt; A voided invoice retains its invoice number and will continue to appear, but does not generate any accounting or tax information.&lt;br&gt;CORRECTIVE -&gt; It’s an issued document to correct an invoice, make a refund or recover VAT on an unpaid invoice.&lt;br&gt;REPLACED -&gt; It is a receipt that has been substituted by an invoice. |
**corrected_invoices** | [**\FacturasBillin\SDK\Model\CorrectedInvoicesAnswerDto[]**](CorrectedInvoicesAnswerDto.md) | Invoices corrected by this invoice. | [optional]
**corrective_data** | [**\FacturasBillin\SDK\Model\CorrectiveDataAnswerDto**](CorrectiveDataAnswerDto.md) | Corrective invoice data. | [optional]
**contact** | [**\FacturasBillin\SDK\Model\DocumentContactAnswerDto**](DocumentContactAnswerDto.md) | Contact of the invoice |
**payment_methods** | [**\FacturasBillin\SDK\Model\GetPaymentMethodDto**](GetPaymentMethodDto.md) | Payment methods of the invoice |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
