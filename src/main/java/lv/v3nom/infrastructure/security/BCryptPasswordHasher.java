package lv.v3nom.infrastructure.security;

import lv.v3nom.domain.security.PasswordHasher;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordHasher implements PasswordHasher {
    @Override
    public String hash(String raw) {
        return BCrypt.hashpw(raw, BCrypt.gensalt());
    }
    @Override
    public boolean matches(String raw, String hashed) {
        return BCrypt.checkpw(raw, hashed);
    }
}
