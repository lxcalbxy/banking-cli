package lv.v3nom.application.dto.responses;

import lv.v3nom.domain.model.Transaction;

import java.math.BigDecimal;

public class TransactionSummaryResponse {
    private final String transactionId;
    private final String type;
    private final String status;
    private final BigDecimal amount;
    private final String timestamp;
    
    public TransactionSummaryResponse(Transaction transaction) {
        this.transactionId = transaction.getTransactionId().getValue();
        this.type = transaction.getTransactionType().getTransactionName();
        this.status = transaction.getTransactionStatus().getValue();
        this.amount = transaction.getAmount().getAmount();
        this.timestamp = transaction.getCreatedAt().toString();
    }

    public String getTransactionId() { return transactionId; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public BigDecimal getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }
}
