

# DocumentContactDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fiscalName** | **String** | The fiscal name of the contact |  [optional] |
|**vatNumberType** | [**VatNumberTypeEnum**](#VatNumberTypeEnum) | The type of the VAT Identification number of the contact |  [optional] |
|**vatNumber** | **String** | Fiscal identification of the contact |  [optional] |
|**taxKey** | **String** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Only spanish or european tax keys are allowed. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 |  [optional] |
|**email** | **String** | The email of the contact |  [optional] |
|**phone** | **String** | Phone of the contact |  [optional] |
|**salesEqTaxCheck** | **Boolean** | Boolean indicating if the sales equivalent tax should be checked |  [optional] |
|**address** | **DocumentContactAddressDto** |  |  [optional] |



## Enum: VatNumberTypeEnum

| Name | Value |
|---- | -----|
| NIF | &quot;NIF&quot; |
| NIF_IVA | &quot;NIF-IVA&quot; |
| PASSPORT | &quot;PASSPORT&quot; |
| ORIGIN | &quot;ORIGIN&quot; |
| CERTIFICATE | &quot;CERTIFICATE&quot; |
| OTHER | &quot;OTHER&quot; |


## Implemented Interfaces

* Serializable


