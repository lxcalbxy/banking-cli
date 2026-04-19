package lv.v3nom.domain.exception;

import lv.v3nom.domain.value.AccountId;
import lv.v3nom.domain.value.CustomerId;
import lv.v3nom.domain.value.Token;
import lv.v3nom.domain.value.TokenStatus;

public class AuthenticationException extends RuntimeException {
    private final AccountId accountId;
    private final CustomerId customerId;
    private final Token token;
    private final TokenStatus tokenStatus;

    public AuthenticationException() {
        super("Authentication failed");
        this.accountId = null;
        this.customerId = null;
        this.token = null;
        this.tokenStatus = null;
    }
    public AuthenticationException(AccountId accountId) {
        super(String.format("Authentication failed. Account ID=[%s]", accountId.getValue()));
        this.accountId = accountId;
        this.customerId = null;
        this.token = null;
        this.tokenStatus = null;
    }
    public AuthenticationException(CustomerId customerId) {
        super(String.format("Authentication failed. Customer ID=[%s]", customerId.getValue()));
        this.accountId = null;
        this.customerId = customerId;
        this.token = null;
        this.tokenStatus = null;
    }
    public AuthenticationException(Token token) {
        super(String.format("Authentication failed. Customer=[%s], Token=[%s]; Expiry=[%s]", token.getCustomerId(), token.getValue(), token.getExpiry()));
        this.accountId = null;
        this.customerId = null;
        this.token = token;
        this.tokenStatus = null;
    }

    public AccountId getAccountId() { return accountId; }
    public CustomerId getCustomerId() { return customerId; }
    public Token getToken() { return token; }
    public TokenStatus getTokenStatus() { return tokenStatus; }
}
