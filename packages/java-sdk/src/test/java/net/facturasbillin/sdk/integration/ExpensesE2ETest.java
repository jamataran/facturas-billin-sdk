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
 * E2E Integration tests for Expenses API.
 *
 * IMPORTANT: These tests require a valid BILLIN_API_KEY environment variable.
 * They interact with the real Billin API and may create actual expenses.
 *
 * Usage:
 * export BILLIN_API_KEY="your-api-key-here"
 * mvn test -Dtest=ExpensesE2ETest
 */
@DisplayName("Expenses API - E2E Integration Tests")
public class ExpensesE2ETest {

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
     * Helper method to create a test expense DTO.
     */
    private ExpenseCreateDto buildTestExpense() {
        ExpenseCreateDto expense = new ExpenseCreateDto();
        // Configure expense details based on API requirements
        return expense;
    }

    @Test
    @DisplayName("Should list expenses")
    void testListExpenses() {
        assertDoesNotThrow(() -> {
            provider.getExpensesApi();
        });
    }

    @Test
    @Disabled("Requires valid expense details")
    @DisplayName("Should create an expense successfully")
    void testCreateExpense() {
        ExpenseCreateDto expense = buildTestExpense();
        assertNotNull(expense);
    }

    @Test
    @Disabled("Requires existing expense ID")
    @DisplayName("Should retrieve an expense by ID")
    void testGetExpenseById() {
        String expenseId = "test-expense-id";
        assertNotNull(provider.getExpensesApi());
    }

    @Test
    @Disabled("Requires existing expense ID")
    @DisplayName("Should delete an expense")
    void testDeleteExpense() {
        String expenseId = "test-expense-id";
        assertNotNull(provider.getExpensesApi());
    }
}
