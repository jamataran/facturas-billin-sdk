

# CreateProductDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the product |  |
|**description** | **String** | Description of the product |  [optional] |
|**reference** | **String** | Reference of the product |  [optional] |
|**taxKey** | **String** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  |
|**buyingPrice** | **BigDecimal** | Buying price of the product |  [optional] |
|**sellingPrice** | **BigDecimal** | Selling price of the product without VAT. If not provided, it will be calculated automatically. |  [optional] |
|**retailPrice** | **BigDecimal** | Selling price of the product including taxes and possible discounts. If not provided, it will be calculated automatically |  [optional] |
|**discountPercentage** | **BigDecimal** | Discount percentage to apply to the product |  [optional] |


## Implemented Interfaces

* Serializable


