package lv.v3nom.application.dto.responses;

import java.math.BigDecimal;

public class AccountResponse {
    private String accountId;
    private String customerId;
    private String status;
    private BigDecimal balance;

    public AccountResponse() {}
    public AccountResponse(String accountId,
                           String customerId,
                           String status,
                           BigDecimal balance) {

        this.accountId = accountId;
        this.customerId = customerId;
        this.status = status;
        this.balance = balance;
    }

    public String getAccountId() { return accountId; }
    public String getCustomerId() { return customerId; }
    public String getStatus() { return status; }
    public BigDecimal getBalance() { return balance; }
}
