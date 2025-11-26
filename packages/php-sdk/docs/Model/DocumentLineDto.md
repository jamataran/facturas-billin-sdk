# # DocumentLineDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** | Name of the line |
**description** | **string** | Description | [optional]
**quantity** | **float** | Quantity |
**unit_price** | **float** | Unit price |
**subtotal** | **float** | Subtotal. It is quantity multiplied by unit price. If not provided, it will be calculated | [optional]
**total_amount** | **float** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |
**discount_percentage** | **float** | Discount percentage. If not provided, it will be calculated | [optional]
**discount_amount** | **float** | Amount to be discounted from the price |
**tax_key** | **string** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |
**tax_base** | **float** | Price without taxes. If not provided, it will be calculated | [optional]
**tax_percentage** | **float** | Tax amount. If not provided, it will be calculated | [optional]
**tax_amount** | **float** | Amount tax to be deducted from the price |
**sales_eq_tax_percentage** | **float** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot;. If not provided, it will be calculated | [optional]
**sales_eq_tax_amount** | **float** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |
**product_id** | **string** | Product Id | [optional]
**product_reference** | **string** | Product reference | [optional]
**order** | **float** |  | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
