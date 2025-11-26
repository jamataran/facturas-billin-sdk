# # DocumentTaxLineBaiDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tax_key** | **string** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |
**tax_base** | **float** | Price without taxes |
**tax_percentage** | **float** | Tax percentage | [optional]
**tax_amount** | **float** | Amount tax to be deducted from the price |
**sales_eq_tax_percentage** | **float** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot; | [optional]
**sales_eq_tax_amount** | **float** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |
**tax_exemption_cause** | **string** | Tax exemption cause | [optional]
**operation** | **string** | Operation | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
