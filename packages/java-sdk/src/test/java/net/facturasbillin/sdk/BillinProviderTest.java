package net.facturasbillin.sdk;

import net.facturasbillin.sdk.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for BillinProvider class.
 * Tests basic initialization and API client access.
 */
@DisplayName("BillinProvider - Unit Tests")
public class BillinProviderTest {

    private BillinProvider provider;
    private static final String TEST_API_KEY = "test-api-key-123";
    private static final String TEST_BASE_URL = "https://api.billin.net";

    @BeforeEach
    void setUp() {
        provider = new BillinProvider(TEST_API_KEY);
    }

    @Test
    @DisplayName("Should create provider with API token")
    void testProviderCreation() {
        assertNotNull(provider);
        assertNotNull(provider.getApiClient());
    }

    @Test
    @DisplayName("Should initialize all API clients")
    void testApiClientsInitialized() {
        assertNotNull(provider.getInvoicesApi());
        assertNotNull(provider.getExpensesApi());
        assertNotNull(provider.getReceiptsApi());
        assertNotNull(provider.getContactsApi());
        assertNotNull(provider.getProductsApi());
        assertNotNull(provider.getPaymentsApi());
        assertNotNull(provider.getAccountingAccountsApi());
        assertNotNull(provider.getQuotesApi());
    }

    @Test
    @DisplayName("Should set base path")
    void testSetBasePath() {
        String newPath = "https://api.example.com";
        provider.setBasePath(newPath);
        assertEquals(newPath, provider.getApiClient().getBasePath());
    }

    @Test
    @DisplayName("Should update bearer token")
    void testSetBearerToken() {
        String newToken = "new-test-token";
        provider.setBearerToken(newToken);
        assertNotNull(provider.getApiClient());
    }

    @Test
    @DisplayName("Should return HTTP client")
    void testGetHttpClient() {
        assertNotNull(provider.getHttpClient());
    }

    @Test
    @DisplayName("Should create provider with custom base URL")
    void testProviderCreationWithCustomUrl() {
        String customUrl = "https://custom.api.com";
        BillinProvider customProvider = new BillinProvider(TEST_API_KEY, customUrl);
        assertEquals(customUrl, customProvider.getApiClient().getBasePath());
    }
}

