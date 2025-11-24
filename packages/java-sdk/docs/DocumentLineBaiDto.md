

# DocumentLineBaiDto


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
|**taxKey** | **String** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  |
|**taxBase** | **BigDecimal** | Price without taxes. If not provided, it will be calculated |  [optional] |
|**taxPercentage** | **BigDecimal** | Tax amount. If not provided, it will be calculated |  [optional] |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  |
|**salesEqTaxPercentage** | **BigDecimal** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot;. If not provided, it will be calculated |  [optional] |
|**salesEqTaxAmount** | **BigDecimal** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |  |
|**productId** | **String** | Product Id |  [optional] |
|**productReference** | **String** | Product reference |  [optional] |
|**taxExemptionCause** | [**TaxExemptionCauseEnum**](#TaxExemptionCauseEnum) | Tax exemption cause |  [optional] |
|**operation** | [**OperationEnum**](#OperationEnum) | Operation |  [optional] |
|**order** | **BigDecimal** |  |  [optional] |



## Enum: TaxExemptionCauseEnum

| Name | Value |
|---- | -----|
| E1 | &quot;E1&quot; |
| E2 | &quot;E2&quot; |
| E3 | &quot;E3&quot; |
| E4 | &quot;E4&quot; |
| E5 | &quot;E5&quot; |
| E6 | &quot;E6&quot; |
| OT | &quot;OT&quot; |
| RL | &quot;RL&quot; |
| VT | &quot;VT&quot; |
| IE | &quot;IE&quot; |



## Enum: OperationEnum

| Name | Value |
|---- | -----|
| SALES_GOODS | &quot;SALES_GOODS&quot; |
| PROVISION_OF_SERVICES | &quot;PROVISION_OF_SERVICES&quot; |


## Implemented Interfaces

* Serializable


