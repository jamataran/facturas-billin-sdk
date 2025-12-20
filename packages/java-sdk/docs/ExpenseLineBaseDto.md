

# ExpenseLineBaseDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the line |  |
|**description** | **String** | Description |  [optional] |
|**totalAmount** | **BigDecimal** | Total amount. It is the sum of the subtotal and the tax amount minus the discount amount |  |
|**taxKey** | **String** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  |
|**taxPercentage** | **BigDecimal** | Tax amount. If not provided, it will be calculated |  [optional] |
|**taxAmount** | **BigDecimal** | Amount tax to be deducted from the price |  |
|**subtotal** | **BigDecimal** | Subtotal of the expense line |  |
|**order** | **BigDecimal** |  |  [optional] |


## Implemented Interfaces

* Serializable


