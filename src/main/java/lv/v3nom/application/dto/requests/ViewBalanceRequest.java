package lv.v3nom.application.dto.requests;

public class ViewBalanceRequest {
    private String currentSessionToken;
    private String idempotencyKey;
    private String accountId;

    public ViewBalanceRequest() {}
    public ViewBalanceRequest(String currentSessionToken,
                              String idempotencyKey,
                              String accountId) {

        this.currentSessionToken = currentSessionToken;
        this.idempotencyKey = idempotencyKey;
        this.accountId = accountId;
    }

    public String getCurrentSessionToken() { return currentSessionToken; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getAccountId() { return accountId; }
}
