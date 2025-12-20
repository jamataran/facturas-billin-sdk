

# RequestTokenUserApiCredentialDto


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**grantType** | [**GrantTypeEnum**](#GrantTypeEnum) | &#39;client_credentials&#39; is the default value if this field is omitted. &#39;password&#39; value is only allowed for highly trusted applications |  [optional] |
|**clientId** | **String** |  |  |
|**clientSecret** | **String** |  |  [optional] |
|**refreshToken** | **String** |  |  [optional] |
|**username** | **String** | Required if grantType is &#39;password&#39; |  [optional] |
|**password** | **String** | Required if grantType is &#39;password&#39; |  [optional] |



## Enum: GrantTypeEnum

| Name | Value |
|---- | -----|
| CLIENT_CREDENTIALS | &quot;client_credentials&quot; |
| REFRESH_TOKEN | &quot;refresh_token&quot; |
| PASSWORD | &quot;password&quot; |


## Implemented Interfaces

* Serializable


