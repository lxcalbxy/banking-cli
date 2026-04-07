package lv.v3nom.domain.model;

import lv.v3nom.domain.value.AccountId;
import lv.v3nom.domain.value.Money;
import lv.v3nom.domain.value.TransactionId;
import lv.v3nom.domain.value.TransactionType;

public class Transaction {
    TransactionId transactionId;
    Money amount;
    AccountId fromAccount;
    AccountId toAccount;
    TransactionType transactionType;

}
