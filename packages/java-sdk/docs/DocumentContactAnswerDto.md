

# DocumentContactAnswerDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fiscalName** | **String** | The fiscal name of the contact |  [optional] |
|**vatNumberType** | [**VatNumberTypeEnum**](#VatNumberTypeEnum) | The type of the VAT Identification number of the contact |  [optional] |
|**vatNumber** | **String** | The VAT Identification number of the contact |  [optional] |
|**isCustomer** | **Boolean** | Boolean indicating if the contact is a customer |  [optional] |
|**isProvider** | **Boolean** | Boolean indicating if the contact is a provider |  [optional] |
|**taxKey** | **Object** | The tax key of the contact |  [optional] |
|**email** | **String** | The email of the contact |  [optional] |
|**additionalEmails** | **List&lt;String&gt;** | Additional emails of the contact |  [optional] |
|**phone** | **String** | The phone of the contact |  [optional] |
|**salesEqTaxCheck** | **Boolean** | Boolean indicating if the sales equivalent tax should be checked |  [optional] |
|**address** | **DocumentContactAddressDto** |  |  [optional] |
|**isTest** | **Boolean** | Boolean indicating if the contact is a test contact |  [optional] |



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


