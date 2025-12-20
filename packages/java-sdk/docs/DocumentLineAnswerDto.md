

# DocumentLineAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the line |  |
|**description** | **String** | Description |  [optional] |
|**productId** | **String** | Product id |  [optional] |
|**quantity** | **BigDecimal** | Quantity |  |
|**unitPrice** | **BigDecimal** | Unit price |  |
|**subtotal** | **BigDecimal** | Subtotal. It is quantity multiplied by unit price. |  |
|**totalAmount** | **BigDecimal** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |  |
|**discountPercentage** | **BigDecimal** | Discount percentage |  |
|**discountAmount** | **BigDecimal** | Amount to be discounted from the price |  |
|**taxKey** | **Object** | Tax key |  |
|**taxBase** | **BigDecimal** | Price without taxes |  |
|**taxPercentage** | **BigDecimal** | Tax percentage |  |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  |
|**salesEqTaxPercentage** | **BigDecimal** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot; |  |
|**salesEqTaxAmount** | **BigDecimal** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |  |
|**taxExemptionGroup** | [**TaxExemptionGroupEnum**](#TaxExemptionGroupEnum) | Tax exemption group |  [optional] |
|**taxExemptionCause** | [**TaxExemptionCauseEnum**](#TaxExemptionCauseEnum) | Tax exemption cause |  [optional] |
|**operation** | [**OperationEnum**](#OperationEnum) | Operation |  [optional] |



## Enum: TaxExemptionGroupEnum

| Name | Value |
|---- | -----|
| EXEMPTION | &quot;EXEMPTION&quot; |
| NOT_SUBJECT | &quot;NOT_SUBJECT&quot; |
| SUBJECT_INVERSION | &quot;SUBJECT_INVERSION&quot; |
| NOT_SUBJECT_INVERSION | &quot;NOT_SUBJECT_INVERSION&quot; |
| SUBJECT_BASIC_DEFAULT | &quot;SUBJECT_BASIC_DEFAULT&quot; |



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


