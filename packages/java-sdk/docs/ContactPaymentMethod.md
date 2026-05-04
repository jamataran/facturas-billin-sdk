

# ContactPaymentMethod


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | A string indicating the payment method type. For now, the only accepted value is \&quot;DIRECT_DEBIT\&quot;, which corresponds to a bank transfer. |  [optional] |
|**data** | **Object** | An object containing the data required for the payment method. For the DIRECT_DEBIT type, it includes the IBAN number. |  [optional] |


## Implemented Interfaces

* Serializable


