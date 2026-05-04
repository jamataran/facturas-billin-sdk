

# SalesReceiptCreateDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**serieId** | **String** | The id of the serie. If provided together with serialCode, the serieId will be used |  [optional] |
|**serialCode** | **String** | Serial Code of the document. If provided together with serieId, the serieId will be used |  [optional] |
|**code** | **BigDecimal** | Code/Number of the document |  [optional] |
|**mask** | **BigDecimal** | Mask used on the code of the document. The complete invoice identifier number is built from the serial code and the code. For example, for a serial code \&quot;F2023\&quot; and a code \&quot;1\&quot; the full identifier number that will appear in the PDF will be \&quot;F20231\&quot;. The mask allows for leading zeros to be included when constructing the complete ID number in the PDF. If we put a mask of 3, the full ID number will be \&quot;F2023001\&quot; |  [optional] |
|**issuedDate** | **String** | The date when the documen was issued |  [optional] |
|**reference** | **String** | The reference of the document |  [optional] |
|**visualLines** | **List&lt;VisualLineDto&gt;** | Visual Lines of the document |  [optional] |
|**taxLines** | **List&lt;DocumentTaxLineBaseDto&gt;** | Tax lines of the document. If not provided, they will be calculated from the lines |  [optional] |
|**comments** | **String** | Comments of the document |  [optional] |
|**currency** | [**CurrencyEnum**](#CurrencyEnum) | Currency used on the document |  [optional] |
|**total** | **DocumentTotalDto** |  |  [optional] |
|**isPaid** | **Boolean** | True if the document is paid. In the case of sending this value to true, a payment will be created with the same date and for the total value of the document. |  [optional] |
|**paidAmount** | **BigDecimal** | Paid amount |  [optional] |
|**retentionAmount** | **BigDecimal** | Amount of retention. If this property is set it will override retentionPercentage if it is also set |  [optional] |
|**retentionPercentage** | **BigDecimal** | Percentage of retention |  [optional] |
|**showProductReference** | **Boolean** | True if product reference should be shown in Pdf |  [optional] |
|**lines** | **List&lt;DocumentLineDto&gt;** | Lines of the document |  [optional] |



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


## Implemented Interfaces

* Serializable


