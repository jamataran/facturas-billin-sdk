

# DocumentTaxLineBaiDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taxKey** | **String** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Only spanish or european tax keys are allowed. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  [optional] |
|**taxBase** | **BigDecimal** | Price without taxes |  [optional] |
|**taxPercentage** | **BigDecimal** | Tax percentage |  [optional] |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  [optional] |
|**salesEqTaxPercentage** | **BigDecimal** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot; |  [optional] |
|**salesEqTaxAmount** | **BigDecimal** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |  [optional] |
|**taxExemptionCause** | [**TaxExemptionCauseEnum**](#TaxExemptionCauseEnum) | Tax exemption cause |  [optional] |
|**operation** | [**OperationEnum**](#OperationEnum) | Operation |  [optional] |



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


