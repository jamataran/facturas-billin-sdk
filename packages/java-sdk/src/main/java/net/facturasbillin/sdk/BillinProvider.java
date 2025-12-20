package net.facturasbillin.sdk;

import net.facturasbillin.sdk.api.AuthApi;
import net.facturasbillin.sdk.api.InvoicesApi;
import net.facturasbillin.sdk.api.ExpensesApi;
import net.facturasbillin.sdk.api.ReceiptsApi;
import net.facturasbillin.sdk.api.ContactsApi;
import net.facturasbillin.sdk.api.ProductsApi;
import net.facturasbillin.sdk.api.PaymentsApi;
import net.facturasbillin.sdk.api.AccountingAccountsApi;
import net.facturasbillin.sdk.api.QuotesApi;
import net.facturasbillin.sdk.model.*;
import net.facturasbillin.sdk.auth.HttpBearerAuth;
import okhttp3.OkHttpClient;

/**
 * Simple wrapper for the Billin API SDK.
 *
 * This provider offers a simplified interface to interact with the Billin API.
 * Users can authenticate and perform operations like creating invoices, expenses, receipts, etc.
 *
 * Example usage:
 * <pre>{@code
 * BillinProvider provider = new BillinProvider("your-api-token");
 *
 * // Create an invoice
 * InvoiceCreateDto invoice = new InvoiceCreateDto();
 * // ... configure invoice details
 * GetInvoice200Response response = provider.getInvoicesApi().createInvoice(invoice);
 * InvoiceDocumentAnswerDto createdInvoice = response.getInvoice();
 * }</pre>
 */
public class BillinProvider {

    private final ApiClient apiClient;
    private final InvoicesApi invoicesApi;
    private final ExpensesApi expensesApi;
    private final ReceiptsApi receiptsApi;
    private final ContactsApi contactsApi;
    private final ProductsApi productsApi;
    private final PaymentsApi paymentsApi;
    private final AccountingAccountsApi accountingAccountsApi;
    private final QuotesApi quotesApi;
    private String bearerToken;

    /**
     * Creates a new BillinProvider with the specified API token.
     *
     * @param apiToken the API token for authentication
     */
    public BillinProvider(String apiToken) {
        this(apiToken, "https://api.billin.net");
    }

    /**
     * Creates a new BillinProvider with the specified API token and base URL.
     *
     * @param apiToken the API token for authentication
     * @param baseUrl  the base URL of the Billin API
     */
    public BillinProvider(String apiToken, String baseUrl) {
        this.bearerToken = apiToken;
        this.apiClient = new ApiClient();
        this.apiClient.setBasePath(baseUrl);

        // Configure authentication
        HttpBearerAuth bearerAuth = (HttpBearerAuth) apiClient.getAuthentication("bearer");
        if (bearerAuth != null) {
            bearerAuth.setBearerToken(apiToken);
        }

        // Initialize API clients
        this.invoicesApi = new InvoicesApi(apiClient);
        this.expensesApi = new ExpensesApi(apiClient);
        this.receiptsApi = new ReceiptsApi(apiClient);
        this.contactsApi = new ContactsApi(apiClient);
        this.productsApi = new ProductsApi(apiClient);
        this.paymentsApi = new PaymentsApi(apiClient);
        this.accountingAccountsApi = new AccountingAccountsApi(apiClient);
        this.quotesApi = new QuotesApi(apiClient);
    }


    /**
     * Gets the underlying API client for advanced usage.
     *
     * @return the API client
     */
    public ApiClient getApiClient() {
        return apiClient;
    }

    /**
     * Gets the invoices API client for direct access.
     *
     * @return the invoices API client
     */
    public InvoicesApi getInvoicesApi() {
        return invoicesApi;
    }

    /**
     * Gets the expenses API client for direct access.
     *
     * @return the expenses API client
     */
    public ExpensesApi getExpensesApi() {
        return expensesApi;
    }

    /**
     * Gets the receipts API client for direct access.
     *
     * @return the receipts API client
     */
    public ReceiptsApi getReceiptsApi() {
        return receiptsApi;
    }

    /**
     * Gets the contacts API client for direct access.
     *
     * @return the contacts API client
     */
    public ContactsApi getContactsApi() {
        return contactsApi;
    }

    /**
     * Gets the products API client for direct access.
     *
     * @return the products API client
     */
    public ProductsApi getProductsApi() {
        return productsApi;
    }

    /**
     * Gets the payments API client for direct access.
     *
     * @return the payments API client
     */
    public PaymentsApi getPaymentsApi() {
        return paymentsApi;
    }

    /**
     * Gets the accounting accounts API client for direct access.
     *
     * @return the accounting accounts API client
     */
    public AccountingAccountsApi getAccountingAccountsApi() {
        return accountingAccountsApi;
    }

    /**
     * Gets the quotes API client for direct access.
     *
     * @return the quotes API client
     */
    public QuotesApi getQuotesApi() {
        return quotesApi;
    }

    /**
     * Sets the base path for the API client.
     *
     * @param basePath the base path
     */
    public void setBasePath(String basePath) {
        apiClient.setBasePath(basePath);
    }

    /**
     * Sets the bearer token for authentication.
     *
     * @param token the bearer token
     */
    public void setBearerToken(String token) {
        this.bearerToken = token;
        HttpBearerAuth bearerAuth = (HttpBearerAuth) apiClient.getAuthentication("bearer");
        if (bearerAuth != null) {
            bearerAuth.setBearerToken(token);
        }
    }

    /**
     * Gets the underlying OkHttp client for advanced customization.
     *
     * @return the OkHttp client
     */
    public OkHttpClient getHttpClient() {
        return apiClient.getHttpClient();
    }
}

