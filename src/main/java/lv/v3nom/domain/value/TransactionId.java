package lv.v3nom.domain.value;

import lv.v3nom.infrastructure.util.IdGenerator;

public class TransactionId {
    private final String value;

    private TransactionId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or blank");
        }
        this.value = value;
    }

    public static TransactionId generate() {
        return new TransactionId(IdGenerator.generateAsciiId());
    }

    public static TransactionId of(String existingId) {
        return new TransactionId(existingId);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionId that = (TransactionId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
