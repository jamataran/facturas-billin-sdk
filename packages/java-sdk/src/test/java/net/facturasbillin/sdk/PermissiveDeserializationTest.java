package net.facturasbillin.sdk;

import com.google.gson.Gson;
import net.facturasbillin.sdk.model.AdditionalExpenseAnswerDto;
import net.facturasbillin.sdk.model.InvoiceDocumentAnswerDto;
import net.facturasbillin.sdk.model.PaymentAnswerDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Reproduces the runtime mismatches that have historically broken the SDK
 * (most recently {@code additionalExpenses: []} where the spec declares an
 * object) and asserts the generated DTOs now degrade gracefully instead of
 * throwing {@link com.google.gson.JsonSyntaxException}.
 *
 * If any assertion here regresses, regenerate the SDK after verifying that
 * {@code packages/java-sdk/templates/pojo.mustache} still wraps
 * {@code validateJsonElement} and the {@code read} adapter in tolerant
 * try/catch blocks.
 */
class PermissiveDeserializationTest {

    private static Gson gson;

    @BeforeAll
    static void initGson() {
        // JSON.gson is populated by an instance initializer; force it to run.
        new JSON();
        gson = JSON.getGson();
    }

    @Test
    void additionalExpensesAsEmptyArrayDoesNotThrow() {
        // Exact shape the live API returned in the production stack trace.
        String json = "{\n" +
                "  \"id\": \"abc-123\",\n" +
                "  \"additionalExpenses\": []\n" +
                "}";

        InvoiceDocumentAnswerDto dto = assertDoesNotThrow(
                () -> gson.fromJson(json, InvoiceDocumentAnswerDto.class));

        assertNotNull(dto);
        // The misshapen field gets dropped — better null than a crash.
        assertNull(dto.getAdditionalExpenses());
    }

    @Test
    void unknownFieldsDoNotThrow() {
        String json = "{\n" +
                "  \"id\": \"abc-123\",\n" +
                "  \"madeUpFieldThatBillinMightAddTomorrow\": 42,\n" +
                "  \"anotherSurprise\": { \"nested\": true }\n" +
                "}";

        InvoiceDocumentAnswerDto dto = assertDoesNotThrow(
                () -> gson.fromJson(json, InvoiceDocumentAnswerDto.class));

        assertNotNull(dto);
    }

    @Test
    void wrongPrimitiveTypeForStringFieldDoesNotThrow() {
        // API returns a number where the spec expects a string.
        String json = "{ \"description\": 12345 }";

        AdditionalExpenseAnswerDto dto = assertDoesNotThrow(
                () -> gson.fromJson(json, AdditionalExpenseAnswerDto.class));

        assertNotNull(dto);
    }

    @Test
    void emptyArrayDeserializedAsObjectReturnsNull() {
        // Top-level shape mismatch: API returned [] for a slot typed as an object.
        AdditionalExpenseAnswerDto dto = assertDoesNotThrow(
                () -> gson.fromJson("[]", AdditionalExpenseAnswerDto.class));

        assertNull(dto);
    }

    @Test
    void missingRequiredFieldDoesNotThrow() {
        // The patcher strips `required`, so an empty payload deserializes cleanly.
        PaymentAnswerDto dto = assertDoesNotThrow(
                () -> gson.fromJson("{}", PaymentAnswerDto.class));

        assertNotNull(dto);
    }
}
