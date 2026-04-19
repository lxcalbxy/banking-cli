package lv.v3nom.domain.exception;

import lv.v3nom.domain.value.Money;
import lv.v3nom.domain.value.TransactionType;

public class InsufficientFundsException extends RuntimeException {
    private final Money balance;
    private final Money attemptedAmount;
    private final TransactionType transactionType;

    public InsufficientFundsException() {
        super(String.format("Operation prohibited. Insufficient funds"));

        this.balance = null;
        this.attemptedAmount = null;
        this.transactionType = null;
    }
    public InsufficientFundsException(TransactionType transactionType) {
        super(String.format("%s not possible. Insufficient funds", transactionType.getTransactionName()));

        this.balance = null;
        this.attemptedAmount = null;
        this.transactionType = transactionType;
    }
    public InsufficientFundsException(Money balance, Money attemptedAmount) {
        super(String.format("Value %s is too large. Balance: ", attemptedAmount, balance));

        this.balance = balance;
        this.attemptedAmount = attemptedAmount;
        this.transactionType = null;
    }

    public Money getBalance() { return balance; }
    public Money getAttemptedAmount() { return attemptedAmount; }
    public TransactionType getTransactionType() { return transactionType; }
}
