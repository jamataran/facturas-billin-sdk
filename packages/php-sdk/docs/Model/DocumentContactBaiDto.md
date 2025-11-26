# # DocumentContactBaiDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fiscal_name** | **string** | The fiscal name of the contact |
**tax_key** | **string** | It must have the format TAXTYPE_INT, TAXTYPE_INT_INT or TAXTYPE_NONTAXABLETAXTYPE_INT.  The TAXTYPE can be IVA, IPSI or IGIC. INT is the tax rate and the second INT is for the decimal part of the tax rate. The NONTAXABLETAXTYPE can be Exempt, NotSubject or ReverseCharge. For the NONTAXABLETAXTYPE the INT must be 0. Some examples are: IVA_Exempt_0, IVA_21, IPSI_3, IGIC_7_5 | [optional]
**email** | **string** | The email of the contact | [optional]
**phone** | **string** | Phone of the contact | [optional]
**sales_eq_tax_check** | **bool** | Boolean indicating if the sales equivalent tax should be checked | [optional]
**vat_number_type** | **string** | The type of the VAT Identification number of the contact |
**vat_number** | **string** | Fiscal identification of the contact |
**address** | [**\FacturasBillin\SDK\Model\DocumentContactAddressDto**](DocumentContactAddressDto.md) | The address of the contact |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
