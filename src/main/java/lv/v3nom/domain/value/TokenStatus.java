package lv.v3nom.domain.value;

public class TokenStatus {
    private final String value;

    private TokenStatus(String value) {
        if (value.isBlank() || value == null) {
            throw new IllegalArgumentException("Status cannot be blank or null");
        }
        this.value = value;
    }

    public static final TokenStatus FRESH =
            new TokenStatus("FRESH");
    public static final TokenStatus EXPIRED =
            new TokenStatus("EXPIRED");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenStatus that = (TokenStatus) o;
        return this.value.equals(that.value);
    }
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
