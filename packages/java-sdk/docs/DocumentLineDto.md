

# DocumentLineDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the line |  |
|**description** | **String** | Description |  [optional] |
|**quantity** | **BigDecimal** | Quantity |  |
|**unitPrice** | **BigDecimal** | Unit price |  |
|**subtotal** | **BigDecimal** | Subtotal. It is quantity multiplied by unit price. If not provided, it will be calculated |  [optional] |
|**totalAmount** | **BigDecimal** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |  |
|**discountPercentage** | **BigDecimal** | Discount percentage. If not provided, it will be calculated |  [optional] |
|**discountAmount** | **BigDecimal** | Amount to be discounted from the price |  |
|**taxKey** | [**TaxKeyEnum**](#TaxKeyEnum) | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Only spanish or european tax keys are allowed. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  |
|**taxBase** | **BigDecimal** | Price without taxes. If not provided, it will be calculated |  [optional] |
|**taxPercentage** | **BigDecimal** | Tax amount. If not provided, it will be calculated |  [optional] |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  |
|**salesEqTaxPercentage** | **BigDecimal** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot;. If not provided, it will be calculated |  [optional] |
|**salesEqTaxAmount** | **BigDecimal** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |  |
|**productId** | **String** | Product Id |  [optional] |
|**productReference** | **String** | Product reference |  [optional] |
|**order** | **BigDecimal** |  |  [optional] |



## Enum: TaxKeyEnum

| Name | Value |
|---- | -----|
| IVA_EXEMPT_0 | &quot;IVA_Exempt_0&quot; |
| IVA_NOTSUBJECT_0 | &quot;IVA_NotSubject_0&quot; |
| IVA_REVERSECHARGE_0 | &quot;IVA_ReverseCharge_0&quot; |
| IGIC_EXEMPT_0 | &quot;IGIC_Exempt_0&quot; |
| IGIC_NOTSUBJECT_0 | &quot;IGIC_NotSubject_0&quot; |
| IGIC_REVERSECHARGE_0 | &quot;IGIC_ReverseCharge_0&quot; |
| IPSI_EXEMPT_0 | &quot;IPSI_Exempt_0&quot; |
| IPSI_NOTSUBJECT_0 | &quot;IPSI_NotSubject_0&quot; |
| IPSI_REVERSECHARGE_0 | &quot;IPSI_ReverseCharge_0&quot; |
| IVA_27 | &quot;IVA_27&quot; |
| IVA_25_5 | &quot;IVA_25_5&quot; |
| IVA_25 | &quot;IVA_25&quot; |
| IVA_24 | &quot;IVA_24&quot; |
| IVA_23 | &quot;IVA_23&quot; |
| IVA_22 | &quot;IVA_22&quot; |
| IVA_21 | &quot;IVA_21&quot; |
| IVA_20 | &quot;IVA_20&quot; |
| IVA_19 | &quot;IVA_19&quot; |
| IVA_18 | &quot;IVA_18&quot; |
| IVA_17 | &quot;IVA_17&quot; |
| IVA_16 | &quot;IVA_16&quot; |
| IVA_15 | &quot;IVA_15&quot; |
| IVA_14 | &quot;IVA_14&quot; |
| IVA_13_5 | &quot;IVA_13_5&quot; |
| IVA_13 | &quot;IVA_13&quot; |
| IVA_12 | &quot;IVA_12&quot; |
| IVA_10 | &quot;IVA_10&quot; |
| IVA_9_5 | &quot;IVA_9_5&quot; |
| IVA_9 | &quot;IVA_9&quot; |
| IVA_8_5 | &quot;IVA_8_5&quot; |
| IVA_8 | &quot;IVA_8&quot; |
| IVA_7_5 | &quot;IVA_7_5&quot; |
| IVA_7 | &quot;IVA_7&quot; |
| IVA_6 | &quot;IVA_6&quot; |
| IVA_5_5 | &quot;IVA_5_5&quot; |
| IVA_5 | &quot;IVA_5&quot; |
| IVA_4_8 | &quot;IVA_4_8&quot; |
| IVA_4 | &quot;IVA_4&quot; |
| IVA_3 | &quot;IVA_3&quot; |
| IVA_2_1 | &quot;IVA_2_1&quot; |
| IVA_2 | &quot;IVA_2&quot; |
| IVA_0 | &quot;IVA_0&quot; |
| IGIC_35 | &quot;IGIC_35&quot; |
| IGIC_20 | &quot;IGIC_20&quot; |
| IGIC_15 | &quot;IGIC_15&quot; |
| IGIC_13_5 | &quot;IGIC_13_5&quot; |
| IGIC_9_5 | &quot;IGIC_9_5&quot; |
| IGIC_7 | &quot;IGIC_7&quot; |
| IGIC_5 | &quot;IGIC_5&quot; |
| IGIC_3 | &quot;IGIC_3&quot; |
| IGIC_0 | &quot;IGIC_0&quot; |
| IPSI_10 | &quot;IPSI_10&quot; |
| IPSI_9 | &quot;IPSI_9&quot; |
| IPSI_8 | &quot;IPSI_8&quot; |
| IPSI_7 | &quot;IPSI_7&quot; |
| IPSI_6 | &quot;IPSI_6&quot; |
| IPSI_5 | &quot;IPSI_5&quot; |
| IPSI_4 | &quot;IPSI_4&quot; |
| IPSI_3_5 | &quot;IPSI_3_5&quot; |
| IPSI_3 | &quot;IPSI_3&quot; |
| IPSI_2 | &quot;IPSI_2&quot; |
| IPSI_1 | &quot;IPSI_1&quot; |
| IPSI_0_5 | &quot;IPSI_0_5&quot; |
| IPSI_0 | &quot;IPSI_0&quot; |


## Implemented Interfaces

* Serializable


