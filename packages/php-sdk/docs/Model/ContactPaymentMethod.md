# # ContactPaymentMethod

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **string** | A string indicating the payment method type. For now, the only accepted value is \&quot;DIRECT_DEBIT\&quot;, which corresponds to a bank transfer. |
**data** | [**\FacturasBillin\SDK\Model\ContactPaymentMethodData**](ContactPaymentMethodData.md) | An object containing the data required for the payment method. For the DIRECT_DEBIT type, it includes the IBAN number. |

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
