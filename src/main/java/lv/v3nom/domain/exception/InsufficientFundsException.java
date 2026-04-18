package lv.v3nom.domain.exception;

import lv.v3nom.domain.value.Money;

public class InsufficientFundsException extends RuntimeException {
    private final Money balance;
    private final Money attemptedAmount;

    public InsufficientFundsException(Money balance, Money attemptedAmount) {
        super(String.format("Value %s is too large. Balance: ", attemptedAmount, balance));

        this.balance = balance;
        this.attemptedAmount = attemptedAmount;
    }

    public Money getBalance() { return balance; }
    public Money getAttemptedAmount() { return attemptedAmount; }
}
