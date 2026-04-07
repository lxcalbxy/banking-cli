package lv.v3nom.domain.value;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Money amount cannot be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Error passing negative value");
        } else {
            this.amount = amount;
        }
    }

    public Money add(BigDecimal amountToAdd) {
        BigDecimal newAmount = this.amount.add(amountToAdd);
        return new Money(newAmount);
    }

    public Money subtract(BigDecimal amountToSubstract) {
        BigDecimal newAmount = this.amount.subtract(amountToSubstract);
        return new Money(newAmount);
    }

    public boolean isPositive() {
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isZeroOrPositive() {
        return amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.compareTo(money.amount) == 0;
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }
}
