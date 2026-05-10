package lv.v3nom.application.dto.requests;

public class OpenAccountRequest {
    private String currentSessionToken;
    private String idempotencyKey;
    private String customerId;

    public OpenAccountRequest() {}
    public OpenAccountRequest(String currentSessionToken,
                              String idempotencyKey,
                              String customerId) {

        this.currentSessionToken = currentSessionToken;
        this.idempotencyKey = idempotencyKey;
        this.customerId = customerId;
    }

    public String currentSessionToken() { return currentSessionToken;}
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getCustomerId() { return customerId; }
}
