package lv.v3nom.domain.model;

import lv.v3nom.domain.value.AccountId;
import lv.v3nom.domain.value.CustomerId;
import lv.v3nom.domain.value.Money;
import lv.v3nom.domain.value.TransactionId;

import java.util.List;

public class Account {
    AccountId accountId;
    CustomerId customerId;
    Money balance;

    List<TransactionId> transactionHistory;
}
