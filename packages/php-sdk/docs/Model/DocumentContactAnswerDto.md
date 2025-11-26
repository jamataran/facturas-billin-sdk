# # DocumentContactAnswerDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fiscal_name** | **string** | The fiscal name of the contact |
**vat_number_type** | **string** | The type of the VAT Identification number of the contact | [optional]
**vat_number** | **string** | The VAT Identification number of the contact | [optional]
**is_customer** | **bool** | Boolean indicating if the contact is a customer | [optional]
**is_provider** | **bool** | Boolean indicating if the contact is a provider | [optional]
**tax_key** | **object** | The tax key of the contact | [optional]
**email** | **string** | The email of the contact | [optional]
**additional_emails** | **string[]** | Additional emails of the contact | [optional]
**phone** | **string** | The phone of the contact | [optional]
**sales_eq_tax_check** | **bool** | Boolean indicating if the sales equivalent tax should be checked | [optional]
**address** | [**\FacturasBillin\SDK\Model\DocumentContactAddressDto**](DocumentContactAddressDto.md) | The address of the contact | [optional]
**is_test** | **bool** | Boolean indicating if the contact is a test contact | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
