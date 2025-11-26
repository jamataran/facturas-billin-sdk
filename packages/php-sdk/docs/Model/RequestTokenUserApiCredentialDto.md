# # RequestTokenUserApiCredentialDto

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**grant_type** | **string** | &#39;client_credentials&#39; is the default value if this field is omitted. &#39;password&#39; value is only allowed for highly trusted applications | [optional] [default to 'client_credentials']
**client_id** | **string** |  |
**client_secret** | **string** |  | [optional]
**refresh_token** | **string** |  | [optional]
**username** | **string** | Required if grantType is &#39;password&#39; | [optional]
**password** | **string** | Required if grantType is &#39;password&#39; | [optional]

[[Back to Model list]](../../README.md#models) [[Back to API list]](../../README.md#endpoints) [[Back to README]](../../README.md)
