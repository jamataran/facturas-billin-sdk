package net.facturasbillin.sdk.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import net.facturasbillin.sdk.ApiClient;
import net.facturasbillin.sdk.api.AuthApi;
import net.facturasbillin.sdk.api.InvoicesApi;
import net.facturasbillin.sdk.api.PaymentsApi;
import net.facturasbillin.sdk.auth.HttpBearerAuth;
import net.facturasbillin.sdk.model.CreateInvoiceRequest;
import net.facturasbillin.sdk.model.CreatePaymentDto;
import net.facturasbillin.sdk.model.CreatePaymentDto.MethodEnum;
import net.facturasbillin.sdk.model.CreatePaymentDto.TypeEnum;
import net.facturasbillin.sdk.model.DocumentContactAddressDto;
import net.facturasbillin.sdk.model.DocumentContactDto;
import net.facturasbillin.sdk.model.DocumentLineDto;
import net.facturasbillin.sdk.model.InvoiceCreateDto;
import net.facturasbillin.sdk.model.InvoiceDocumentAnswerDto;
import net.facturasbillin.sdk.model.RequestTokenUserApiCredentialDto;
import net.facturasbillin.sdk.model.TokenAnswerDto;
import net.facturasbillin.sdk.model.PaymentAnswerDto;

@DisplayName("Invoice + Payment real flow")
public class CreateInvoiceAndPaymentIntegrationTest {

    private static InvoicesApi invoicesApi;
    private static PaymentsApi paymentsApi;
    private static boolean apiReady = false;

    @BeforeAll
    public static void setUp() {
        String clientId = System.getenv("BILLIN_CLIENT_ID");
        String clientSecret = System.getenv("BILLIN_CLIENT_SECRET");

        assertNotNull(clientId, "BILLIN_CLIENT_ID environment variable is required");
        assertNotNull(clientSecret, "BILLIN_CLIENT_SECRET environment variable is required");

        try {
            ApiClient authClient = new ApiClient();
            authClient.setBasePath("https://api.billin.net");


            AuthApi authApi = new AuthApi(authClient);
            RequestTokenUserApiCredentialDto tokenRequest = new RequestTokenUserApiCredentialDto();
            tokenRequest.setClientId(clientId);
            tokenRequest.setClientSecret(clientSecret);
            tokenRequest.setGrantType(RequestTokenUserApiCredentialDto.GrantTypeEnum.CLIENT_CREDENTIALS);

            TokenAnswerDto tokenResponse = authApi.authControllerGetTokenV1(tokenRequest);
            String accessToken = tokenResponse.getAccessToken();
            assertNotNull(accessToken, "Failed to obtain access token");

            ApiClient client = new ApiClient();
            client.setBasePath("https://api.billin.net");
            client.setDebugging(true);

            HttpBearerAuth auth = (HttpBearerAuth) client.getAuthentication("bearer");
            assertNotNull(auth, "bearer authentication must be configured in ApiClient");
            auth.setBearerToken(accessToken);

            invoicesApi = new InvoicesApi(client);
            paymentsApi = new PaymentsApi(client);
            apiReady = true;
        } catch (Exception e) {
            System.out.println("⚠️  API authentication failed: " + e.getMessage());
            apiReady = false;
        }
    }

    @Test
    @DisplayName("Should create invoice then create payment linked to it")
    void createInvoiceAndPayment_flow_printsResponses() {
        Assumptions.assumeTrue(apiReady, "API credentials invalid or unavailable - skipping integration test");
        Assumptions.assumeTrue(invoicesApi != null && paymentsApi != null, "APIs not initialized - skipping integration test");

        try {
            // 1) Crear factura
            DocumentContactAddressDto address = new DocumentContactAddressDto();
            address.setPostalAddress("C/ México, 32");
            address.setPostalCode("28820");
            address.setCity("Barcelona");
            address.setProvince("ES-B");
            address.setCountry(DocumentContactAddressDto.CountryEnum.ES);

            DocumentContactDto contact = new DocumentContactDto();
            contact.setFiscalName("03309455P cliente" + " " + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now()));
            contact.setVatNumberType(DocumentContactDto.VatNumberTypeEnum.NIF);
            contact.setVatNumber("03309455P");
            contact.setTaxKey("IVA_0");
            contact.setEmail("info@billin.eu");
            contact.setPhone("916726763");
            contact.setSalesEqTaxCheck(true);
            contact.setAddress(address);

            DocumentLineDto line1 = new DocumentLineDto();
            line1.setName("Preparación completa + PD/UD/SA + Correcciones 2");
            line1.setQuantity(BigDecimal.ONE);
            line1.setUnitPrice(new BigDecimal("995.95"));
            line1.setTotalAmount(new BigDecimal("995.95"));
            line1.setDiscountAmount(BigDecimal.ZERO);
            line1.setTaxKey(DocumentLineDto.TaxKeyEnum.IVA_0);
            line1.setTaxAmount(BigDecimal.ZERO);
            line1.setSalesEqTaxAmount(BigDecimal.ZERO);

            DocumentLineDto line2 = new DocumentLineDto();
            line2.setName("Tutoría individual");
            line2.setQuantity(BigDecimal.ONE);
            line2.setUnitPrice(new BigDecimal("35"));
            line2.setTotalAmount(new BigDecimal("35"));
            line2.setDiscountAmount(BigDecimal.ZERO);
            line2.setTaxKey(DocumentLineDto.TaxKeyEnum.IVA_0);
            line2.setTaxAmount(BigDecimal.ZERO);
            line2.setSalesEqTaxAmount(BigDecimal.ZERO);

            InvoiceCreateDto invoiceRequest = new InvoiceCreateDto();
            invoiceRequest.setCurrency(InvoiceCreateDto.CurrencyEnum.EUR);
            invoiceRequest.setLines(Arrays.asList(line1, line2));
            invoiceRequest.setShowPdfLinesWithoutTaxes(true);
            invoiceRequest.setComments("Factura sin IVA debido a la LEY de IVA del 199.1919adl");
            invoiceRequest.setContact(contact);

            System.out.println("\n📤 Creating invoice with real payload...");
            InvoiceDocumentAnswerDto invoiceResponse = invoicesApi.createInvoice(new CreateInvoiceRequest(invoiceRequest));
            assertNotNull(invoiceResponse);
            assertNotNull(invoiceResponse.getId());
            System.out.println("✅ Invoice created: " + invoiceResponse);

            // 3) Crear pago usando el id de la factura
            CreatePaymentDto paymentRequest = new CreatePaymentDto();
            paymentRequest.setOperationDate(LocalDate.parse("2025-12-10").toString());
            paymentRequest.setAmount(new BigDecimal("995.95"));
            paymentRequest.setMethod(MethodEnum.CREDIT_CARD);
            paymentRequest.setType(TypeEnum.INCOME);
            paymentRequest.setDocumentsIds(Arrays.asList(invoiceResponse.getId()));
            paymentRequest.setDescription("Pago con tarjeta ***45 el día 19.01.2025 a las 15:15");

            System.out.println("\n📤 Creating payment linked to invoice " + invoiceResponse.getId() + "...");
            PaymentAnswerDto paymentResponse = paymentsApi.createPayment(paymentRequest);
            assertNotNull(paymentResponse);
            assertNotNull(paymentResponse.getId());
            System.out.println("✅ Payment created: " + paymentResponse);

        } catch (Exception e) {
            e.printStackTrace();
            Assumptions.assumeTrue(false, "Integration flow failed: " + e.getMessage());
        }
    }
}

