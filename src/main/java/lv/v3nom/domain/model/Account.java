package lv.v3nom.domain.model;

import lv.v3nom.domain.value.*;
import lv.v3nom.infrastructure.util.impl.SystemDateTimeProvider;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final AccountId accountId;
    private final CustomerId ownerId;
    private Money balance;
    private AccountStatus accountStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Account(AccountId accountId,
                    CustomerId ownerId,
                    Money balance,
                    AccountStatus accountStatus,
                    LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Account open(CustomerId ownerId) {
        SystemDateTimeProvider clock = new SystemDateTimeProvider();
        if (ownerId == null) {
            throw new IllegalArgumentException(
                    "Cannot open account. Customer is not specified");
        }
        return new Account(
                AccountId.generate(),
                ownerId,
                Money.ZERO,
                AccountStatus.ACTIVE,
                clock.now(),
                clock.now());
    }
    public static Account reconstitute(AccountId accountId,
                                       CustomerId ownerId,
                                       Money balance,
                                       AccountStatus accountStatus,
                                       LocalDateTime createdAt,
                                       LocalDateTime updatedAt) {
        Account account = new Account(
                accountId, ownerId, balance, accountStatus,
                createdAt, updatedAt);
        account.updatedAt = updatedAt;
        return account;
    }
    public void deposit(Money amount) {
        if (amount.isNegativeOrZero()) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        if (accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Deposits are disabled for " + accountStatus.getValue() + " account");
        }
        this.balance = this.balance.add(amount);
        this.updatedAt = new SystemDateTimeProvider().now();
    }
    public void withdraw(Money amount) {
        if (amount.isNegativeOrZero()) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalArgumentException("Withdraws are disabled for " + accountStatus.getValue() + " account");
        }
        if (this.balance.isLessThan(amount)) {
            throw new IllegalArgumentException("Insufficient funds. Balance: " + this.balance);
        }
        this.balance = this.balance.subtract(amount);
        this.updatedAt = new SystemDateTimeProvider().now();
    }
    public void close() {
        if (this.balance.isPositive()) {
            throw new IllegalStateException("Cannot close account with non-zero balance");
        }
        if (this.accountStatus == AccountStatus.BLOCKED || this.accountStatus == AccountStatus.PENDING_VERIFICATION) {
            throw new IllegalStateException("Cannot close " + this.accountStatus.getValue() + " account");
        }
        this.accountStatus = AccountStatus.CLOSED;
        this.updatedAt = new SystemDateTimeProvider().now();
    }
    public void freeze() {
        SystemDateTimeProvider clock = new SystemDateTimeProvider();
        if (this.accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot freeze " + this.accountStatus.getValue() + " account");
        }
        this.accountStatus = AccountStatus.FROZEN;
        this.updatedAt = new SystemDateTimeProvider().now();
    }
    public void transferToAccount(Account target, Money amount) {
        if (amount.isNegativeOrZero()) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (this.accountId.equals(target.accountId)) {
            throw new IllegalArgumentException("Cannot send self");
        }
        if (this.accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot transfer, sender account inactive");
        }
        if (target.accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot transfer, receiver account inactive");
        }
        if (this.balance.isLessThan(amount)) {
            throw new IllegalArgumentException("Cannot transfer, insufficient funds");
        }

        this.balance = this.balance.subtract(amount);
        target.balance = target.balance.add(amount);
    }

    public AccountId getAccountId() { return accountId; }
    public CustomerId getOwnerId() { return ownerId; }
    public Money getBalance() { return balance; }
    public AccountStatus getAccountStatus() { return accountStatus; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}