package lv.v3nom.domain.security;

public interface PasswordHasher {
    public String hash(String raw);
    public boolean matches(String raw, String hashed); // impl in infrastructure
}
