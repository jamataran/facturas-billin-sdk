package net.facturasbillin.sdk.integration;

import net.facturasbillin.sdk.BillinProvider;
import net.facturasbillin.sdk.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Assumptions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * E2E Integration tests for Invoices API.
 *
 * IMPORTANT: These tests require a valid BILLIN_API_KEY environment variable.
 * They interact with the real Billin API and may create actual invoices.
 *
 * Usage:
 * export BILLIN_API_KEY="your-api-key-here"
 * mvn test -Dtest=InvoicesE2ETest
 *
 * Or with turbo:
 * npm run test:e2e
 */
@DisplayName("Invoices API - E2E Integration Tests")
public class InvoicesE2ETest {

    private BillinProvider provider;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("BILLIN_API_KEY");
        Assumptions.assumeTrue(apiKey != null && !apiKey.isBlank(),
            "BILLIN_API_KEY environment variable is not set. " +
            "Please set it with: export BILLIN_API_KEY='your-api-key'");
        provider = new BillinProvider(apiKey);
    }

    @Test
    @DisplayName("Should list invoices from API")
    void testListInvoices() {
        assertDoesNotThrow(() -> {
            GetInvoicesListAnswerDto result = provider.getInvoicesApi().getInvoicesList();
            assertNotNull(result);

        });
    }

    @Test
    @DisplayName("Should handle empty or populated invoice list")
    void testEmptyInvoiceList() {
        assertDoesNotThrow(() -> {
            GetInvoicesListAnswerDto result = provider.getInvoicesApi().getInvoicesList();
            assertNotNull(result);
            // List might be empty, that's ok
            List<InvoiceDocumentAnswerDto> invoices = result.getData();
            assertNotNull(invoices);
        });
    }

    @Test
    @DisplayName("Should query invoices with filters")
    void testListInvoicesWithQuery() {
        assertDoesNotThrow(() -> {
            GetInvoicesListQueryDto query = new GetInvoicesListQueryDto();
            query.setLimit(10);

            GetInvoicesListAnswerDto result = provider.getInvoicesApi().getInvoicesList(query);
            assertNotNull(result);
            assertNotNull(result.getData());
        });
    }

    /**
     * TEMPLATE: Create a simple invoice.
     *
     * This test shows the structure needed to create an invoice.
     * You need to:
     * 1. Get or create a contact (customer) ID
     * 2. Get or create product IDs
     * 3. Configure invoice details
     * 4. Add lines with products/services
     * 5. Add taxes if needed
     */
    @Test
    @Disabled("Requires valid contact ID and product setup in your account")
    @DisplayName("Should create an invoice successfully")
    void testCreateInvoiceTemplate() {
        // Build invoice
        InvoiceCreateDto invoice = new InvoiceCreateDto();
        invoice.setType(InvoiceCreateDto.TypeEnum.INVOICE);
        invoice.setDate(LocalDate.now());
        invoice.setDueDate(LocalDate.now().plusDays(30));

        // Set contact (customer) - REQUIRES VALID CONTACT ID
        DocumentContactDto contact = new DocumentContactDto();
        contact.setId("REPLACE_WITH_CONTACT_ID");  // Get from getContactsList() or create first
        invoice.setContact(contact);

        // Add invoice line (product/service)
        DocumentLineDto line = new DocumentLineDto();
        line.setDescription("Servicio profesional");
        line.setQuantity(1.0);
        line.setUnitPrice(100.0);
        invoice.addLinesItem(line);

        // Create invoice
        assertDoesNotThrow(() -> {
            GetInvoice200Response response = provider.getInvoicesApi().createInvoice(invoice);
            assertNotNull(response);
            assertNotNull(response.getInvoice());
            assertNotNull(response.getInvoice().getId());
            System.out.println("✅ Invoice created: " + response.getInvoice().getId());
        });
    }

    @Test
    @Disabled("Requires existing invoice ID")
    @DisplayName("Should retrieve an invoice by ID")
    void testGetInvoiceById() {
        String invoiceId = "REPLACE_WITH_INVOICE_ID";
        assertDoesNotThrow(() -> {
            GetInvoice200Response response = provider.getInvoicesApi().getInvoice(invoiceId);
            assertNotNull(response);
            assertNotNull(response.getInvoice());
            assertEquals(invoiceId, response.getInvoice().getId());
        });
    }

    @Test
    @Disabled("Requires existing invoice ID")
    @DisplayName("Should update an invoice")
    void testUpdateInvoice() {
        String invoiceId = "REPLACE_WITH_INVOICE_ID";

        InvoiceCreateDto updateData = new InvoiceCreateDto();
        updateData.setType(InvoiceCreateDto.TypeEnum.INVOICE);

        assertDoesNotThrow(() -> {
            GetInvoice200Response response = provider.getInvoicesApi().updateInvoice(invoiceId, updateData);
            assertNotNull(response);
        });
    }

    @Test
    @Disabled("Requires existing invoice ID")
    @DisplayName("Should delete an invoice")
    void testDeleteInvoice() {
        String invoiceId = "REPLACE_WITH_INVOICE_ID";
        assertDoesNotThrow(() -> {
            provider.getInvoicesApi().deleteInvoice(invoiceId);
        });
    }
}
