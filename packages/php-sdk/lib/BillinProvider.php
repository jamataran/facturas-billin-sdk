<?php
/**
 * BillinProvider
 * PHP version 7.4 | 8.0+
 *
 * @category Class
 * @package  FacturasBillin\SDK
 * @author   OpenAPI Generator team
 * @link     https://openapi-generator.tech
 */

/**
 * Billin Api
 *
 * Simple wrapper for the Billin API SDK.
 *
 * The version of the OpenAPI document: 1.0
 */

namespace FacturasBillin\SDK;

use GuzzleHttp\Client;
use GuzzleHttp\ClientInterface;
use FacturasBillin\SDK\Api\AuthApi;
use FacturasBillin\SDK\Api\InvoicesApi;
use FacturasBillin\SDK\Api\ExpensesApi;
use FacturasBillin\SDK\Api\ReceiptsApi;
use FacturasBillin\SDK\Api\ContactsApi;
use FacturasBillin\SDK\Api\ProductsApi;
use FacturasBillin\SDK\Api\PaymentsApi;
use FacturasBillin\SDK\Api\AccountingAccountsApi;
use FacturasBillin\SDK\Api\QuotesApi;

/**
 * BillinProvider Class Doc Comment
 *
 * Simple wrapper for the Billin API SDK.
 *
 * This provider offers a simplified interface to interact with the Billin API.
 * Users can authenticate and perform operations like creating invoices, expenses, receipts, etc.
 *
 * Example usage:
 * <code>
 * $provider = new BillinProvider('your-api-token');
 *
 * // Create an invoice
 * $invoice = new \FacturasBillin\SDK\Model\InvoiceCreateDto();
 * // ... configure invoice details
 * $response = $provider->getInvoicesApi()->createInvoice($invoice);
 * </code>
 *
 * @category Class
 * @package  FacturasBillin\SDK
 * @author   jamataran
 * @link     https://github.com/jamataran/facturas-billin-sdk
 */
class BillinProvider
{
    /**
     * @var Configuration
     */
    private $config;

    /**
     * @var ClientInterface
     */
    private $httpClient;

    /**
     * @var AuthApi
     */
    private $authApi;

    /**
     * @var InvoicesApi
     */
    private $invoicesApi;

    /**
     * @var ExpensesApi
     */
    private $expensesApi;

    /**
     * @var ReceiptsApi
     */
    private $receiptsApi;

    /**
     * @var ContactsApi
     */
    private $contactsApi;

    /**
     * @var ProductsApi
     */
    private $productsApi;

    /**
     * @var PaymentsApi
     */
    private $paymentsApi;

    /**
     * @var AccountingAccountsApi
     */
    private $accountingAccountsApi;

    /**
     * @var QuotesApi
     */
    private $quotesApi;

    /**
     * Default base URL for the Billin API
     */
    public const DEFAULT_BASE_URL = 'https://api.billin.net';

    /**
     * Creates a new BillinProvider with the specified API token.
     *
     * @param string               $apiToken   The API token for authentication (Bearer token)
     * @param string               $baseUrl    The base URL of the Billin API (optional)
     * @param ClientInterface|null $httpClient Custom Guzzle HTTP client (optional)
     */
    public function __construct(
        string $apiToken,
        string $baseUrl = self::DEFAULT_BASE_URL,
        ?ClientInterface $httpClient = null
    ) {
        $this->config = new Configuration();
        $this->config->setHost($baseUrl);
        $this->config->setAccessToken($apiToken);

        $this->httpClient = $httpClient ?? new Client();

        // Initialize API clients
        $this->initializeApis();
    }

    /**
     * Initialize all API clients
     *
     * @return void
     */
    private function initializeApis(): void
    {
        $this->authApi = new AuthApi($this->httpClient, $this->config);
        $this->invoicesApi = new InvoicesApi($this->httpClient, $this->config);
        $this->expensesApi = new ExpensesApi($this->httpClient, $this->config);
        $this->receiptsApi = new ReceiptsApi($this->httpClient, $this->config);
        $this->contactsApi = new ContactsApi($this->httpClient, $this->config);
        $this->productsApi = new ProductsApi($this->httpClient, $this->config);
        $this->paymentsApi = new PaymentsApi($this->httpClient, $this->config);
        $this->accountingAccountsApi = new AccountingAccountsApi($this->httpClient, $this->config);
        $this->quotesApi = new QuotesApi($this->httpClient, $this->config);
    }

    /**
     * Gets the configuration object for advanced usage.
     *
     * @return Configuration
     */
    public function getConfig(): Configuration
    {
        return $this->config;
    }

    /**
     * Gets the underlying HTTP client.
     *
     * @return ClientInterface
     */
    public function getHttpClient(): ClientInterface
    {
        return $this->httpClient;
    }

    /**
     * Gets the Auth API client for authentication operations.
     *
     * @return AuthApi
     */
    public function getAuthApi(): AuthApi
    {
        return $this->authApi;
    }

    /**
     * Gets the Invoices API client for invoice operations.
     *
     * @return InvoicesApi
     */
    public function getInvoicesApi(): InvoicesApi
    {
        return $this->invoicesApi;
    }

    /**
     * Gets the Expenses API client for expense operations.
     *
     * @return ExpensesApi
     */
    public function getExpensesApi(): ExpensesApi
    {
        return $this->expensesApi;
    }

    /**
     * Gets the Receipts API client for receipt/sales receipt operations.
     *
     * @return ReceiptsApi
     */
    public function getReceiptsApi(): ReceiptsApi
    {
        return $this->receiptsApi;
    }

    /**
     * Gets the Contacts API client for contact operations.
     *
     * @return ContactsApi
     */
    public function getContactsApi(): ContactsApi
    {
        return $this->contactsApi;
    }

    /**
     * Gets the Products API client for product operations.
     *
     * @return ProductsApi
     */
    public function getProductsApi(): ProductsApi
    {
        return $this->productsApi;
    }

    /**
     * Gets the Payments API client for payment operations.
     *
     * @return PaymentsApi
     */
    public function getPaymentsApi(): PaymentsApi
    {
        return $this->paymentsApi;
    }

    /**
     * Gets the Accounting Accounts API client for accounting account operations.
     *
     * @return AccountingAccountsApi
     */
    public function getAccountingAccountsApi(): AccountingAccountsApi
    {
        return $this->accountingAccountsApi;
    }

    /**
     * Gets the Quotes API client for quote operations.
     *
     * @return QuotesApi
     */
    public function getQuotesApi(): QuotesApi
    {
        return $this->quotesApi;
    }

    /**
     * Sets the base path for the API client.
     *
     * @param string $basePath The base path
     * @return $this
     */
    public function setBasePath(string $basePath): self
    {
        $this->config->setHost($basePath);
        $this->initializeApis();
        return $this;
    }

    /**
     * Sets the bearer token for authentication.
     *
     * @param string $token The bearer token
     * @return $this
     */
    public function setBearerToken(string $token): self
    {
        $this->config->setAccessToken($token);
        $this->initializeApis();
        return $this;
    }

    /**
     * Creates a BillinProvider by authenticating with client credentials.
     *
     * This is a factory method that handles the OAuth2 client_credentials flow.
     *
     * @param string               $clientId     The client ID
     * @param string               $clientSecret The client secret
     * @param string               $baseUrl      The base URL of the Billin API (optional)
     * @param ClientInterface|null $httpClient   Custom Guzzle HTTP client (optional)
     * @return BillinProvider
     * @throws ApiException If authentication fails
     */
    public static function withClientCredentials(
        string $clientId,
        string $clientSecret,
        string $baseUrl = self::DEFAULT_BASE_URL,
        ?ClientInterface $httpClient = null
    ): BillinProvider {
        $config = new Configuration();
        $config->setHost($baseUrl);

        $client = $httpClient ?? new Client();
        $authApi = new AuthApi($client, $config);

        // Create token request
        $tokenRequest = new \FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto();
        $tokenRequest->setClientId($clientId);
        $tokenRequest->setClientSecret($clientSecret);
        $tokenRequest->setGrantType(\FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto::GRANT_TYPE_CLIENT_CREDENTIALS);

        // Get access token
        $tokenResponse = $authApi->authControllerGetTokenV1($tokenRequest);
        $accessToken = $tokenResponse->getAccessToken();

        return new BillinProvider($accessToken, $baseUrl, $client);
    }

    /**
     * Creates a BillinProvider by authenticating with username and password.
     *
     * This is a factory method that handles the OAuth2 password flow.
     *
     * @param string               $clientId     The client ID
     * @param string               $clientSecret The client secret
     * @param string               $username     The username
     * @param string               $password     The password
     * @param string               $baseUrl      The base URL of the Billin API (optional)
     * @param ClientInterface|null $httpClient   Custom Guzzle HTTP client (optional)
     * @return BillinProvider
     * @throws ApiException If authentication fails
     */
    public static function withPassword(
        string $clientId,
        string $clientSecret,
        string $username,
        string $password,
        string $baseUrl = self::DEFAULT_BASE_URL,
        ?ClientInterface $httpClient = null
    ): BillinProvider {
        $config = new Configuration();
        $config->setHost($baseUrl);

        $client = $httpClient ?? new Client();
        $authApi = new AuthApi($client, $config);

        // Create token request
        $tokenRequest = new \FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto();
        $tokenRequest->setClientId($clientId);
        $tokenRequest->setClientSecret($clientSecret);
        $tokenRequest->setUsername($username);
        $tokenRequest->setPassword($password);
        $tokenRequest->setGrantType(\FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto::GRANT_TYPE_PASSWORD);

        // Get access token
        $tokenResponse = $authApi->authControllerGetTokenV1($tokenRequest);
        $accessToken = $tokenResponse->getAccessToken();

        return new BillinProvider($accessToken, $baseUrl, $client);
    }
}
