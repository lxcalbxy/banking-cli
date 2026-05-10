package lv.v3nom.application.dto.requests;

public class AuthRequest {
    private String currentSessionToken;
    private String idempotencyKey;
    private String email;
    private String password;

    public AuthRequest() {} // for possible frameworks
    public AuthRequest(String currentSessionToken,
                       String idempotencyKey,
                       String email,
                       String password) {

        this.currentSessionToken = currentSessionToken;
        this.idempotencyKey = idempotencyKey;
        this.email = email;
        this.password = password;
    }

    public String getCurrentSessionToken() { return currentSessionToken; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    // dtos r immutable serializable simple objs, no setters (or return void)
}
