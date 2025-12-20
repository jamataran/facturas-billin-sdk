package net.facturasbillin.sdk;

import net.facturasbillin.sdk.api.*;
import net.facturasbillin.sdk.model.*;

/**
 * Ejemplos de uso de la librería Billin Java SDK.
 *
 * Estos ejemplos muestran cómo usar las características principales de la SDK.
 */
public class BillinProviderExample {

    public static void main(String[] args) {
        // Obtener API key (en producción, usar variables de entorno)
        String apiKey = System.getenv("BILLIN_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("Error: BILLIN_API_KEY environment variable not set");
            System.exit(1);
        }

        // Crear proveedor de Billin
        BillinProvider provider = new BillinProvider(apiKey);

        try {
            // Ejemplo 1: Acceder a diferentes APIs
            exampleAccessApis(provider);

            // Ejemplo 2: Listar facturas (si existen)
            exampleListInvoices(provider);

            // Ejemplo 3: Listar contactos (si existen)
            exampleListContacts(provider);

            // Ejemplo 4: Listar gastos (si existen)
            exampleListExpenses(provider);

            // Ejemplo 5: Acceder a configuración avanzada
            exampleAdvancedConfiguration(provider);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Ejemplo 1: Acceder a diferentes APIs
     */
    private static void exampleAccessApis(BillinProvider provider) {
        System.out.println("=== Ejemplo 1: Acceder a APIs ===\n");

        // Obtener referencias a las diferentes APIs
        InvoicesApi invoicesApi = provider.getInvoicesApi();
        ExpensesApi expensesApi = provider.getExpensesApi();
        ContactsApi contactsApi = provider.getContactsApi();
        PaymentsApi paymentsApi = provider.getPaymentsApi();
        ProductsApi productsApi = provider.getProductsApi();
        ReceiptsApi receiptsApi = provider.getReceiptsApi();
        AccountingAccountsApi accountingAccountsApi = provider.getAccountingAccountsApi();
        QuotesApi quotesApi = provider.getQuotesApi();

        System.out.println("✓ APIs inicializadas correctamente");
        System.out.println("  - InvoicesApi");
        System.out.println("  - ExpensesApi");
        System.out.println("  - ContactsApi");
        System.out.println("  - PaymentsApi");
        System.out.println("  - ProductsApi");
        System.out.println("  - ReceiptsApi");
        System.out.println("  - AccountingAccountsApi");
        System.out.println("  - QuotesApi\n");
    }

    /**
     * Ejemplo 2: Listar facturas
     */
    private static void exampleListInvoices(BillinProvider provider) {
        System.out.println("=== Ejemplo 2: Listar Facturas ===\n");

        try {
            InvoicesApi invoicesApi = provider.getInvoicesApi();
            // Nota: Los parámetros exactos dependen de la especificación OpenAPI
            System.out.println("Listando facturas...");
            System.out.println("(Implementa según tu API específica)\n");

            // GetInvoicesListAnswerDto invoices = invoicesApi.listInvoices(...);
            // if (invoices != null && invoices.getInvoices() != null) {
            //     System.out.println("Facturas encontradas: " + invoices.getInvoices().size());
            // }

        } catch (Exception e) {
            System.err.println("Error al listar facturas: " + e.getMessage());
        }
    }

    /**
     * Ejemplo 3: Listar contactos
     */
    private static void exampleListContacts(BillinProvider provider) {
        System.out.println("=== Ejemplo 3: Listar Contactos ===\n");

        try {
            ContactsApi contactsApi = provider.getContactsApi();
            System.out.println("Listando contactos...");
            System.out.println("(Implementa según tu API específica)\n");

            // GetContactListAnswerDto contacts = contactsApi.listContacts(...);
            // if (contacts != null && contacts.getContacts() != null) {
            //     System.out.println("Contactos encontrados: " + contacts.getContacts().size());
            // }

        } catch (Exception e) {
            System.err.println("Error al listar contactos: " + e.getMessage());
        }
    }

    /**
     * Ejemplo 4: Listar gastos
     */
    private static void exampleListExpenses(BillinProvider provider) {
        System.out.println("=== Ejemplo 4: Listar Gastos ===\n");

        try {
            ExpensesApi expensesApi = provider.getExpensesApi();
            System.out.println("Listando gastos...");
            System.out.println("(Implementa según tu API específica)\n");

            // GetExpenseListAnswerDto expenses = expensesApi.listExpenses(...);
            // if (expenses != null && expenses.getExpenses() != null) {
            //     System.out.println("Gastos encontrados: " + expenses.getExpenses().size());
            // }

        } catch (Exception e) {
            System.err.println("Error al listar gastos: " + e.getMessage());
        }
    }

    /**
     * Ejemplo 5: Configuración avanzada
     */
    private static void exampleAdvancedConfiguration(BillinProvider provider) {
        System.out.println("=== Ejemplo 5: Configuración Avanzada ===\n");

        // Obtener el cliente API subyacente para configuraciones avanzadas
        ApiClient apiClient = provider.getApiClient();
        System.out.println("Base Path: " + apiClient.getBasePath());

        // Obtener el cliente HTTP de OkHttp para customizaciones
        okhttp3.OkHttpClient httpClient = provider.getHttpClient();
        System.out.println("HTTP Client configurado correctamente\n");

        // Cambiar URL base si es necesario
        String newUrl = "https://api.billin.net";
        provider.setBasePath(newUrl);
        System.out.println("URL base actualizada a: " + newUrl + "\n");
    }
}

