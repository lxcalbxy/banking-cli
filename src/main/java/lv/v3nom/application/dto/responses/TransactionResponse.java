package lv.v3nom.application.dto.responses;

import java.math.BigDecimal;

public class TransactionResponse {
    private String transactionId;
    private String type;
    private String status;
    private String sourceAccountId;
    private String targetAccountId;
    private BigDecimal amount;
    private String failureReason; // blank most times
    private String createdAt;
    private String completedAt;

    public TransactionResponse() {}
    public TransactionResponse(String transactionId,
                               String type,
                               String status,
                               String sourceAccountId,
                               String targetAccountId,
                               BigDecimal amount,
                               String failureReason,
                               String createdAt,
                               String completedAt) {

        this.transactionId = transactionId;
        this.type = type;
        this.status = status;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.failureReason = failureReason;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    public String getTransactionId() { return transactionId; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getSourceAccountId() { return sourceAccountId; }
    public String getTargetAccountId() { return targetAccountId; }
    public BigDecimal getAmount() { return amount; }
    public String getFailureReason() { return failureReason; }
    public String getCreatedAt() { return createdAt; }
    public String getCompletedAt() { return completedAt; }
}
