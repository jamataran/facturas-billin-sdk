

# DocumentLineAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the line |  [optional] |
|**description** | **String** | Description |  [optional] |
|**productId** | **String** | Product id |  [optional] |
|**quantity** | **BigDecimal** | Quantity |  [optional] |
|**unitPrice** | **BigDecimal** | Unit price |  [optional] |
|**subtotal** | **BigDecimal** | Subtotal. It is quantity multiplied by unit price. |  [optional] |
|**totalAmount** | **BigDecimal** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |  [optional] |
|**discountPercentage** | **BigDecimal** | Discount percentage |  [optional] |
|**discountAmount** | **BigDecimal** | Amount to be discounted from the price |  [optional] |
|**taxKey** | **Object** | Tax key |  [optional] |
|**taxBase** | **BigDecimal** | Price without taxes |  [optional] |
|**taxPercentage** | **BigDecimal** | Tax percentage |  [optional] |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  [optional] |
|**salesEqTaxPercentage** | **BigDecimal** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot; |  [optional] |
|**salesEqTaxAmount** | **BigDecimal** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |  [optional] |
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


