# # ExpenseLineBaseDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** | Name of the line |
**description** | **string** | Description | [optional]
**total_amount** | **float** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |
**tax_key** | **string** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |
**tax_percentage** | **float** | Tax amount. If not provided, it will be calculated | [optional]
**tax_amount** | **float** | Amount tax to be deducted from the price |
**subtotal** | **float** | Subtotal of the expense line |
**order** | **float** |  | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
