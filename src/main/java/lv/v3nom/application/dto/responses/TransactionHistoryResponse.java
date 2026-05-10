package lv.v3nom.application.dto.responses;

import java.util.List;

public class TransactionHistoryResponse {
    private List<TransactionSummaryResponse> transactions;
    private int totalCount;

    public TransactionHistoryResponse() {}
    public TransactionHistoryResponse(List<TransactionSummaryResponse> transactions, int totalCount) {
        this.transactions = transactions;
        this.totalCount = totalCount;
    }
}
