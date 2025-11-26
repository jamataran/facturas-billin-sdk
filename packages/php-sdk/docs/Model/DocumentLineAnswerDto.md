# # DocumentLineAnswerDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **string** | Name of the line |
**description** | **string** | Description | [optional]
**product_id** | **string** | Product id | [optional]
**quantity** | **float** | Quantity |
**unit_price** | **float** | Unit price |
**subtotal** | **float** | Subtotal. It is quantity multiplied by unit price. |
**total_amount** | **float** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |
**discount_percentage** | **float** | Discount percentage |
**discount_amount** | **float** | Amount to be discounted from the price |
**tax_key** | **object** | Tax key |
**tax_base** | **float** | Price without taxes |
**tax_percentage** | **float** | Tax percentage |
**tax_amount** | **float** | Amount tax to be deducted from the price |
**sales_eq_tax_percentage** | **float** | Sales equivalent tax percentage. In Spain it is called \&quot;Porcentaje de Recargoo de equivalencia\&quot; |
**sales_eq_tax_amount** | **float** | Sales equivalent tax amount. In Spain it is called \&quot;Cantidad de Recargoo de equivalencia\&quot; |
**tax_exemption_group** | **string** | Tax exemption group | [optional]
**tax_exemption_cause** | **string** | Tax exemption cause | [optional]
**operation** | **string** | Operation | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
