

# QuoteDocumentAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The id of the document |  |
|**createdAt** | **OffsetDateTime** | The date when the document was created |  |
|**updatedAt** | **OffsetDateTime** | The date when the document was last updated |  |
|**issuedDateTime** | **OffsetDateTime** | The datetime when the document was issued |  [optional] |
|**issuedDate** | **String** | The date when the document was issued |  [optional] |
|**ownerInfo** | [**BusinessBaseAnswerDto**](BusinessBaseAnswerDto.md) |  |  |
|**currency** | [**CurrencyEnum**](#CurrencyEnum) | Currency used on the document |  |
|**comments** | **String** | Comments of the document |  [optional] |
|**serieId** | **String** | The id of the serie |  [optional] |
|**serialCode** | **String** | Serial Code of the document |  [optional] |
|**mask** | **BigDecimal** | Mask used on the code of the document. The complete invoice identifier number is built from the serial code and the code. For example, for a serial code \&quot;F2023\&quot; and a code \&quot;1\&quot; the full identifier number that will appear in the PDF will be \&quot;F20231\&quot;. The mask allows for leading zeros to be included when constructing the complete ID number in the PDF. If we put a mask of 3, the full ID number will be \&quot;F2023001\&quot; |  [optional] |
|**code** | **BigDecimal** | Code/Number of the document |  [optional] |
|**identifier** | **String** | The identifier of the document |  [optional] |
|**dueDate** | **String** | The due date of the document |  |
|**reference** | **String** | The reference of the document |  [optional] |
|**total** | [**DocumentTotalAnswerDto**](DocumentTotalAnswerDto.md) |  |  |
|**lines** | [**List&lt;DocumentLineAnswerDto&gt;**](DocumentLineAnswerDto.md) | Lines of the quote |  |
|**visualLines** | [**List&lt;VisualLineDto&gt;**](VisualLineDto.md) | Visual Lines of the document |  |
|**taxLines** | [**List&lt;DocumentTaxLineAnswerDto&gt;**](DocumentTaxLineAnswerDto.md) | Tax lines of the quote |  |
|**additionalExpenses** | [**AdditionalExpenseAnswerDto**](AdditionalExpenseAnswerDto.md) |  |  |
|**retentionPercentage** | **BigDecimal** | Percentage of retention |  |
|**retentionAmount** | **BigDecimal** | Retention amount |  |
|**paidAmount** | **BigDecimal** | Paid amount |  |
|**documentType** | [**DocumentTypeEnum**](#DocumentTypeEnum) | Type of the document |  [optional] |
|**category** | [**CategoryEnum**](#CategoryEnum) | Type of the document |  [optional] |
|**contact** | [**DocumentContactAnswerDto**](DocumentContactAnswerDto.md) |  |  |
|**paymentMethods** | [**GetPaymentMethodDto**](GetPaymentMethodDto.md) |  |  |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the quote |  |



## Enum: CurrencyEnum

| Name | Value |
|---- | -----|
| ALL | &quot;ALL&quot; |
| AFN | &quot;AFN&quot; |
| ARS | &quot;ARS&quot; |
| AWG | &quot;AWG&quot; |
| AUD | &quot;AUD&quot; |
| AZN | &quot;AZN&quot; |
| BBD | &quot;BBD&quot; |
| BDT | &quot;BDT&quot; |
| BGN | &quot;BGN&quot; |
| BMD | &quot;BMD&quot; |
| BND | &quot;BND&quot; |
| BOB | &quot;BOB&quot; |
| BAM | &quot;BAM&quot; |
| BWP | &quot;BWP&quot; |
| BRL | &quot;BRL&quot; |
| BZD | &quot;BZD&quot; |
| CAD | &quot;CAD&quot; |
| KYD | &quot;KYD&quot; |
| CLP | &quot;CLP&quot; |
| CNY | &quot;CNY&quot; |
| COP | &quot;COP&quot; |
| CRC | &quot;CRC&quot; |
| HRK | &quot;HRK&quot; |
| CUP | &quot;CUP&quot; |
| CZK | &quot;CZK&quot; |
| DKK | &quot;DKK&quot; |
| DOP | &quot;DOP&quot; |
| XCD | &quot;XCD&quot; |
| EGP | &quot;EGP&quot; |
| SVC | &quot;SVC&quot; |
| EUR | &quot;EUR&quot; |
| FKP | &quot;FKP&quot; |
| FJD | &quot;FJD&quot; |
| GHS | &quot;GHS&quot; |
| GIP | &quot;GIP&quot; |
| GTQ | &quot;GTQ&quot; |
| GGP | &quot;GGP&quot; |
| GYD | &quot;GYD&quot; |
| HNL | &quot;HNL&quot; |
| HKD | &quot;HKD&quot; |
| HUF | &quot;HUF&quot; |
| ISK | &quot;ISK&quot; |
| INR | &quot;INR&quot; |
| IDR | &quot;IDR&quot; |
| IRR | &quot;IRR&quot; |
| IMP | &quot;IMP&quot; |
| ILS | &quot;ILS&quot; |
| JMD | &quot;JMD&quot; |
| JPY | &quot;JPY&quot; |
| JEP | &quot;JEP&quot; |
| KZT | &quot;KZT&quot; |
| KPW | &quot;KPW&quot; |
| KGS | &quot;KGS&quot; |
| LAK | &quot;LAK&quot; |
| LBP | &quot;LBP&quot; |
| LRD | &quot;LRD&quot; |
| MKD | &quot;MKD&quot; |
| MYR | &quot;MYR&quot; |
| MUR | &quot;MUR&quot; |
| MXN | &quot;MXN&quot; |
| MNT | &quot;MNT&quot; |
| MZN | &quot;MZN&quot; |
| NAD | &quot;NAD&quot; |
| NPR | &quot;NPR&quot; |
| ANG | &quot;ANG&quot; |
| NZD | &quot;NZD&quot; |
| NIO | &quot;NIO&quot; |
| NGN | &quot;NGN&quot; |
| NOK | &quot;NOK&quot; |
| OMR | &quot;OMR&quot; |
| PKR | &quot;PKR&quot; |
| PAB | &quot;PAB&quot; |
| PYG | &quot;PYG&quot; |
| PEN | &quot;PEN&quot; |
| PHP | &quot;PHP&quot; |
| PLN | &quot;PLN&quot; |
| QAR | &quot;QAR&quot; |
| RON | &quot;RON&quot; |
| RUB | &quot;RUB&quot; |
| SHP | &quot;SHP&quot; |
| SAR | &quot;SAR&quot; |
| RSD | &quot;RSD&quot; |
| SCR | &quot;SCR&quot; |
| SGD | &quot;SGD&quot; |
| SBD | &quot;SBD&quot; |
| SOS | &quot;SOS&quot; |
| KRW | &quot;KRW&quot; |
| ZAR | &quot;ZAR&quot; |
| LKR | &quot;LKR&quot; |
| SEK | &quot;SEK&quot; |
| CHF | &quot;CHF&quot; |
| SRD | &quot;SRD&quot; |
| SYP | &quot;SYP&quot; |
| TWD | &quot;TWD&quot; |
| THB | &quot;THB&quot; |
| TTD | &quot;TTD&quot; |
| TRY | &quot;TRY&quot; |
| TVD | &quot;TVD&quot; |
| UAH | &quot;UAH&quot; |
| AED | &quot;AED&quot; |
| GBP | &quot;GBP&quot; |
| USD | &quot;USD&quot; |
| UYU | &quot;UYU&quot; |
| UZS | &quot;UZS&quot; |
| VEF | &quot;VEF&quot; |
| VND | &quot;VND&quot; |
| YER | &quot;YER&quot; |
| XOF | &quot;XOF&quot; |
| ZWD | &quot;ZWD&quot; |



## Enum: DocumentTypeEnum

| Name | Value |
|---- | -----|
| INVOICE | &quot;INVOICE&quot; |
| EXPENSE | &quot;EXPENSE&quot; |
| QUOTE | &quot;QUOTE&quot; |
| TEST_INVOICE | &quot;TEST_INVOICE&quot; |
| PROFORMA_INVOICE | &quot;PROFORMA_INVOICE&quot; |
| CORRECTIVE | &quot;CORRECTIVE&quot; |
| DELIVERY_NOTE | &quot;DELIVERY_NOTE&quot; |



## Enum: CategoryEnum

| Name | Value |
|---- | -----|
| _206_SOFTWARE_APPLICATIONS | &quot;206_SOFTWARE_APPLICATIONS&quot; |
| _210_LAND_AND_NATURAL_RESOURCES | &quot;210_LAND_AND_NATURAL_RESOURCES&quot; |
| _211_BUILDINGS | &quot;211_BUILDINGS&quot; |
| _212_TECHNICAL_INSTALLATIONS | &quot;212_TECHNICAL_INSTALLATIONS&quot; |
| _213_MACHINERY | &quot;213_MACHINERY&quot; |
| _214_TOOLS | &quot;214_TOOLS&quot; |
| _215_OTHER_INSTALLATIONS | &quot;215_OTHER_INSTALLATIONS&quot; |
| _216_FURNITURE | &quot;216_FURNITURE&quot; |
| _217_INFORMATION_PROCESSING_EQUIPMENT | &quot;217_INFORMATION_PROCESSING_EQUIPMENT&quot; |
| _218_TRANSPORT_ELEMENTS | &quot;218_TRANSPORT_ELEMENTS&quot; |
| _219_OTHER_TANGIBLE_ASSETS | &quot;219_OTHER_TANGIBLE_ASSETS&quot; |
| _600_WARE | &quot;600_WARE&quot; |
| _601_RAW_MATERIALS | &quot;601_RAW_MATERIALS&quot; |
| _602_SUPPLIES | &quot;602_SUPPLIES&quot; |
| _607_OTHER_COMPANIES | &quot;607_OTHER_COMPANIES&quot; |
| _608_RETURNS | &quot;608_RETURNS&quot; |
| _610_VARIATIONS_MERCHADISE | &quot;610_VARIATIONS_MERCHADISE&quot; |
| _611_VARIATIONS_RAW_MATERIALS | &quot;611_VARIATIONS_RAW_MATERIALS&quot; |
| _612_VARIATIONS_OTHER_SUPPLIES | &quot;612_VARIATIONS_OTHER_SUPPLIES&quot; |
| _620_VARIATIONS_OTHER_SUPPLIES | &quot;620_VARIATIONS_OTHER_SUPPLIES&quot; |
| _621_RENTING | &quot;621_RENTING&quot; |
| _622_REPAIRS_AND_MAINTENANCE | &quot;622_REPAIRS_AND_MAINTENANCE&quot; |
| _623_RETENTION_SERVICES | &quot;623_RETENTION_SERVICES&quot; |
| _624_LOGISTICS | &quot;624_LOGISTICS&quot; |
| _625_INSURANCE | &quot;625_INSURANCE&quot; |
| _626_BANKING_EXPENSES | &quot;626_BANKING_EXPENSES&quot; |
| _627_ADVERTISING | &quot;627_ADVERTISING&quot; |
| _628_GENERAL_SUPPLIES | &quot;628_GENERAL_SUPPLIES&quot; |
| _629_OTHER_SERVICES | &quot;629_OTHER_SERVICES&quot; |
| _630_CURRENT_TAX | &quot;630_CURRENT_TAX&quot; |
| _6301_DEFERRED_TAX | &quot;6301_DEFERRED_TAX&quot; |
| _631_OTHER_TAXES | &quot;631_OTHER_TAXES&quot; |
| _640_SALARY | &quot;640_SALARY&quot; |
| _641_INDEMNIFICATIONS | &quot;641_INDEMNIFICATIONS&quot; |
| _642_SOCIAL_SECURITY_TAXES | &quot;642_SOCIAL_SECURITY_TAXES&quot; |
| _649_SOCIAL_EXPENSES | &quot;649_SOCIAL_EXPENSES&quot; |
| _6623_BANK_DEBT_INTEREST | &quot;6623_BANK_DEBT_INTEREST&quot; |
| _6624_INTEREST_DEBTS_OTHER_COMPANIES | &quot;6624_INTEREST_DEBTS_OTHER_COMPANIES&quot; |
| _668_TANGIBLE_FIXED_EQUIPMENT | &quot;668_TANGIBLE_FIXED_EQUIPMENT&quot; |
| _669_OTHER_FINANCIAL_EXPENSES | &quot;669_OTHER_FINANCIAL_EXPENSES&quot; |
| _678_EXCEPTIONAL_EXPENSES | &quot;678_EXCEPTIONAL_EXPENSES&quot; |
| _680_AMORTIZATION_INTANGIBLE_FIXED_ASSETS | &quot;680_AMORTIZATION_INTANGIBLE_FIXED_ASSETS&quot; |
| _681_AMORTIZATION_PROPERTY_AND_EQUIPMENT | &quot;681_AMORTIZATION_PROPERTY_AND_EQUIPMENT&quot; |
| _682_AMORTIZATION_INVESTMENT_PROPERTY | &quot;682_AMORTIZATION_INVESTMENT_PROPERTY&quot; |
| UNCATEGORIZED | &quot;UNCATEGORIZED&quot; |
| OTHER | &quot;OTHER&quot; |
| OWED | &quot;OWED&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;PENDING&quot; |
| ACCEPTED | &quot;ACCEPTED&quot; |
| REJECTED | &quot;REJECTED&quot; |


## Implemented Interfaces

* Serializable


