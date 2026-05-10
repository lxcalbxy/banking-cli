package lv.v3nom.application.dto.requests;

import java.math.BigDecimal;

public class TransferRequest {
    private String currentSessionToken;
    private String idempotencyKey;
    private String sourceAccountId;
    private String targetAccountId;
    private BigDecimal amount;

    public TransferRequest() {}
    public TransferRequest(String currentSessionToken,
                           String idempotencyKey,
                           String sourceAccountId,
                           String targetAccountId,
                           BigDecimal amount) {

        this.currentSessionToken = currentSessionToken;
        this.idempotencyKey = idempotencyKey;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }

    public String getCurrentSessionToken() { return currentSessionToken; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getSourceAccountId() { return sourceAccountId; }
    public String getTargetAccountId() { return targetAccountId; }
    public BigDecimal getAmount() { return amount; }
}
