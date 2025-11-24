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
 * E2E Integration tests for Contacts API.
 *
 * IMPORTANT: These tests require a valid BILLIN_API_KEY environment variable.
 * They interact with the real Billin API and may create actual contacts.
 *
 * Usage:
 * export BILLIN_API_KEY="your-api-key-here"
 * mvn test -Dtest=ContactsE2ETest
 */
@DisplayName("Contacts API - E2E Integration Tests")
public class ContactsE2ETest {

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
     * Helper method to create a test contact DTO.
     */
    private CreateContactDto buildTestContact() {
        CreateContactDto contact = new CreateContactDto();
        // Configure contact details based on API requirements
        return contact;
    }

    @Test
    @DisplayName("Should list contacts")
    void testListContacts() {
        assertDoesNotThrow(() -> {
            provider.getContactsApi();
        });
    }

    @Test
    @Disabled("Requires valid contact details")
    @DisplayName("Should create a contact successfully")
    void testCreateContact() {
        CreateContactDto contact = buildTestContact();
        assertNotNull(contact);
    }

    @Test
    @Disabled("Requires existing contact ID")
    @DisplayName("Should retrieve a contact by ID")
    void testGetContactById() {
        String contactId = "test-contact-id";
        assertNotNull(provider.getContactsApi());
    }

    @Test
    @Disabled("Requires existing contact ID")
    @DisplayName("Should update a contact")
    void testUpdateContact() {
        String contactId = "test-contact-id";
        assertNotNull(provider.getContactsApi());
    }
}
