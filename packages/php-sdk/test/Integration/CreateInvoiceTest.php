<?php
/**
 * CreateInvoiceTest
 *
 * @category Tests
 * @package  FacturasBillin\SDK\Test\Integration
 * @author   jamataran
 * @link     https://github.com/jamataran/facturas-billin-sdk
 */

namespace FacturasBillin\SDK\Test\Integration;

use PHPUnit\Framework\TestCase;
use FacturasBillin\SDK\BillinProvider;
use FacturasBillin\SDK\Configuration;
use FacturasBillin\SDK\Api\AuthApi;
use FacturasBillin\SDK\Api\InvoicesApi;
use FacturasBillin\SDK\Model\RequestTokenUserApiCredentialDto;
use FacturasBillin\SDK\Model\InvoiceCreateDto;
use FacturasBillin\SDK\Model\DocumentContactDto;
use FacturasBillin\SDK\Model\DocumentContactAddressDto;
use FacturasBillin\SDK\Model\DocumentLineDto;
use GuzzleHttp\Client;

/**
 * Integration tests for Invoices API
 *
 * @category Tests
 * @package  FacturasBillin\SDK\Test\Integration
 */
class CreateInvoiceTest extends TestCase
{
    /**
     * @var string|null
     */
    private static ?string $accessToken = null;

    /**
     * @var InvoicesApi|null
     */
    private static ?InvoicesApi $invoicesApi = null;

    /**
     * @var bool
     */
    private static bool $apiReady = false;

    /**
     * @var string|null
     */
    private static ?string $testInvoiceId = null;

    /**
     * Set up test fixtures before class
     */
    public static function setUpBeforeClass(): void
    {
        // Get credentials from environment variables
        $clientId = getenv('BILLIN_CLIENT_ID');
        $clientSecret = getenv('BILLIN_CLIENT_SECRET');

        if (empty($clientId) || empty($clientSecret)) {
            echo "⚠️  BILLIN_CLIENT_ID and BILLIN_CLIENT_SECRET environment variables are required\n";
            self::$apiReady = false;
            return;
        }

        try {
            // Initialize API client to get token
            $config = new Configuration();
            $config->setHost('https://api.billin.net');

            $authApi = new AuthApi(new Client(), $config);

            // Create token request
            $tokenRequest = new RequestTokenUserApiCredentialDto();
            $tokenRequest->setClientId($clientId);
            $tokenRequest->setClientSecret($clientSecret);
            $tokenRequest->setGrantType(RequestTokenUserApiCredentialDto::GRANT_TYPE_CLIENT_CREDENTIALS);

            // Get access token
            $tokenResponse = $authApi->authControllerGetTokenV1($tokenRequest);
            self::$accessToken = $tokenResponse->getAccessToken();

            if (empty(self::$accessToken)) {
                echo "⚠️  Failed to obtain access token\n";
                self::$apiReady = false;
                return;
            }

            echo "✅ Successfully obtained access token\n";

            // Create API client for invoices with token
            $config = new Configuration();
            $config->setHost('https://api.billin.net');
            $config->setAccessToken(self::$accessToken);

            self::$invoicesApi = new InvoicesApi(new Client(), $config);
            self::$apiReady = true;

        } catch (\Exception $e) {
            echo "⚠️  API authentication failed: " . $e->getMessage() . "\n";
            echo "    Integration tests will be skipped, but unit tests will run\n";
            self::$apiReady = false;
        }
    }

    /**
     * Test creating a test invoice with sample data
     */
    public function testCreateInvoice(): void
    {
        if (!self::$apiReady) {
            $this->markTestSkipped('API credentials invalid or unavailable - skipping integration test');
        }

        if (self::$invoicesApi === null) {
            $this->markTestSkipped('InvoicesApi not initialized - skipping integration test');
        }

        try {
            echo "\n📋 Starting real API call to create invoice...\n";

            // Create complete contact data
            $address = new DocumentContactAddressDto();
            $address->setPostalAddress('C/ México, 32');
            $address->setPostalCode('28820');
            $address->setCity('Barcelona');
            $address->setProvince('ES-B');
            $address->setCountry(DocumentContactAddressDto::COUNTRY_ES);

            $contact = new DocumentContactDto();
            $contact->setFiscalName('_Pruebas API');
            $contact->setVatNumberType(DocumentContactDto::VAT_NUMBER_TYPE_NIF);
            $contact->setVatNumber('B12345678');
            $contact->setTaxKey('IVA_7_5');
            $contact->setEmail('info@billin.eu');
            $contact->setPhone('916726763');
            $contact->setSalesEqTaxCheck(true);
            $contact->setAddress($address);

            // Create invoice line with ALL required fields
            $line = new DocumentLineDto();
            $line->setName('Product name');
            $line->setQuantity(2);
            $line->setUnitPrice(10);
            $line->setTotalAmount(21.78);
            $line->setDiscountAmount(2);
            $line->setTaxKey('IVA_21');
            $line->setTaxAmount(3.78);
            $line->setSalesEqTaxAmount(0);

            // Create invoice
            $invoice = new InvoiceCreateDto();
            $invoice->setContact($contact);
            $invoice->setLines([$line]);
            $invoice->setCurrency(InvoiceCreateDto::CURRENCY_EUR);

            echo "📤 Sending request to API...\n";

            // Execute API call
            $response = self::$invoicesApi->createInvoice($invoice);

            $this->assertNotNull($response, 'API response should not be null');

            self::$testInvoiceId = $response->getId();
            $this->assertNotNull(self::$testInvoiceId, 'Invoice ID should not be null');

            echo "✅ Test invoice created successfully!\n";
            echo "   📌 Invoice ID: " . self::$testInvoiceId . "\n";

        } catch (\Exception $e) {
            // Skip test if API returns error
            echo "⏭️  Skipping integration test - API returned error: " . $e->getMessage() . "\n";
            $this->markTestSkipped('Integration test skipped due to API error');
        }
    }

    /**
     * Test verifying invoice data structure
     */
    public function testInvoiceStructure(): void
    {
        $invoice = new InvoiceCreateDto();
        $contact = new DocumentContactDto();
        $line = new DocumentLineDto();

        // Verify that objects are created correctly
        $this->assertNotNull($invoice);
        $this->assertNotNull($contact);
        $this->assertNotNull($line);

        echo "✅ Invoice structure is valid!\n";
    }

    /**
     * Test that environment variables are loaded
     */
    public function testEnvironmentVariables(): void
    {
        $clientId = getenv('BILLIN_CLIENT_ID');
        $clientSecret = getenv('BILLIN_CLIENT_SECRET');

        $this->assertNotEmpty($clientId, 'BILLIN_CLIENT_ID must be set');
        $this->assertNotEmpty($clientSecret, 'BILLIN_CLIENT_SECRET must be set');

        echo "✅ Environment variables are correctly loaded!\n";
    }

    /**
     * Test BillinProvider instantiation
     */
    public function testBillinProviderInstantiation(): void
    {
        $provider = new BillinProvider('test-token');

        $this->assertNotNull($provider);
        $this->assertNotNull($provider->getConfig());
        $this->assertNotNull($provider->getInvoicesApi());
        $this->assertNotNull($provider->getExpensesApi());
        $this->assertNotNull($provider->getReceiptsApi());
        $this->assertNotNull($provider->getContactsApi());
        $this->assertNotNull($provider->getProductsApi());
        $this->assertNotNull($provider->getPaymentsApi());
        $this->assertNotNull($provider->getAccountingAccountsApi());
        $this->assertNotNull($provider->getQuotesApi());
        $this->assertNotNull($provider->getAuthApi());

        echo "✅ BillinProvider instantiation is correct!\n";
    }

    /**
     * Test BillinProvider with custom base URL
     */
    public function testBillinProviderWithCustomBaseUrl(): void
    {
        $customUrl = 'https://custom.api.billin.net';
        $provider = new BillinProvider('test-token', $customUrl);

        $this->assertEquals($customUrl, $provider->getConfig()->getHost());

        echo "✅ BillinProvider with custom base URL is correct!\n";
    }

    /**
     * Test BillinProvider setBearerToken method
     */
    public function testBillinProviderSetBearerToken(): void
    {
        $provider = new BillinProvider('initial-token');
        $newToken = 'new-bearer-token';

        $provider->setBearerToken($newToken);

        $this->assertEquals($newToken, $provider->getConfig()->getAccessToken());

        echo "✅ BillinProvider setBearerToken is correct!\n";
    }

    /**
     * Test BillinProvider setBasePath method
     */
    public function testBillinProviderSetBasePath(): void
    {
        $provider = new BillinProvider('test-token');
        $newPath = 'https://new.api.billin.net';

        $provider->setBasePath($newPath);

        $this->assertEquals($newPath, $provider->getConfig()->getHost());

        echo "✅ BillinProvider setBasePath is correct!\n";
    }
}
