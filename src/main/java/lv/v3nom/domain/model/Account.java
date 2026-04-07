package lv.v3nom.domain.model;

import lv.v3nom.domain.value.*;

import java.time.LocalDateTime;
import java.util.List;

public class Account {
    private AccountId accountId;
    private CustomerId ownerId;
    private Money balance;
    private AccountStatus accountStatus;
    private LocalDateTime createdAt;

    List<TransactionId> transactionHistory;
}
