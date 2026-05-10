package lv.v3nom.application.dto.requests;

public class TransactionHistoryRequest {
    private String currentSessionToken;
    private String idempotencyKey;
    private String accountId;
    private String fromDate;
    private String toDate;

    public TransactionHistoryRequest() {}
    public TransactionHistoryRequest(String currentSessionToken,
                                     String idempotencyKey,
                                     String accountId,
                                     String fromDate,
                                     String toDate) {

        this.currentSessionToken = currentSessionToken;
        this.idempotencyKey = idempotencyKey;
        this.accountId = accountId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getCurrentSessionToken() { return currentSessionToken; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getAccountId() { return accountId; }
    public String getFromDate() { return fromDate; }
    public String getToDate() { return toDate; }
}
