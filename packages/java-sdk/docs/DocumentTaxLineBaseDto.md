

# DocumentTaxLineBaseDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taxKey** | **String** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  |
|**taxBase** | **BigDecimal** | Price without taxes |  |
|**taxPercentage** | **BigDecimal** | Tax percentage |  [optional] |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  |
|**salesEqTaxPercentage** | **BigDecimal** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot; |  [optional] |
|**salesEqTaxAmount** | **BigDecimal** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |  |


## Implemented Interfaces

* Serializable


