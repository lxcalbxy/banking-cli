package lv.v3nom.application.dto.requests;

import java.math.BigDecimal;

public class WithdrawRequest {
    private String currentSessionToken;
    private String idempotencyKey;
    private String accountId;
    private BigDecimal amount;

    public WithdrawRequest() {}
    public WithdrawRequest(String currentSessionToken,
                           String idempotencyKey,
                           String accountId,
                           BigDecimal amount) {

        this.currentSessionToken = currentSessionToken;
        this.idempotencyKey = idempotencyKey;
        this.accountId = accountId;
        this.amount = amount;
    }

    public String getCurrentSessionToken() { return currentSessionToken; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getAccountId() { return accountId; }
    public BigDecimal getAmount() { return amount; }
}
