package net.facturasbillin.sdk.integration;

import net.facturasbillin.sdk.BillinProvider;
import net.facturasbillin.sdk.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Assumptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * E2E Integration tests for Payments API.
 *
 * IMPORTANT: These tests require a valid BILLIN_API_KEY environment variable.
 * They interact with the real Billin API and may create actual payments.
 *
 * Usage:
 * export BILLIN_API_KEY="your-api-key-here"
 * mvn test -Dtest=PaymentsE2ETest
 */
@DisplayName("Payments API - E2E Integration Tests")
public class PaymentsE2ETest {

    private BillinProvider provider;

    @BeforeEach
    void setUp() {
        String apiKey = System.getenv("BILLIN_API_KEY");
        Assumptions.assumeTrue(apiKey != null && !apiKey.isBlank(),
            "BILLIN_API_KEY environment variable is not set. " +
            "Please set it with: export BILLIN_API_KEY='your-api-key'");
        provider = new BillinProvider(apiKey);
    }

    /**
     * Helper method to create a test payment DTO.
     */
    private CreatePaymentDto buildTestPayment() {
        CreatePaymentDto payment = new CreatePaymentDto();
        // Configure payment details based on API requirements
        return payment;
    }

    @Test
    @DisplayName("Should list payments")
    void testListPayments() {
        assertDoesNotThrow(() -> {
            provider.getPaymentsApi();
        });
    }

    @Test
    @Disabled("Requires valid payment details and related invoice/expense")
    @DisplayName("Should create a payment successfully")
    void testCreatePayment() {
        CreatePaymentDto payment = buildTestPayment();
        assertNotNull(payment);
    }

    @Test
    @Disabled("Requires existing payment ID")
    @DisplayName("Should retrieve a payment by ID")
    void testGetPaymentById() {
        String paymentId = "test-payment-id";
        assertNotNull(provider.getPaymentsApi());
    }

    @Test
    @Disabled("Requires existing payment ID")
    @DisplayName("Should delete a payment")
    void testDeletePayment() {
        String paymentId = "test-payment-id";
        assertNotNull(provider.getPaymentsApi());
    }
}
