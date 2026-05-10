package lv.v3nom.application.dto.responses;

public class AuthResponse {
    private String customerId;
    private String sessionToken;
    private boolean success;
    private String status;
    private String name;

    public AuthResponse() {}
    public AuthResponse(String customerId,
                        String sessionToken,
                        boolean success,
                        String status,
                        String name) {

        this.customerId = customerId;
        this.sessionToken = sessionToken;
        this.success = success;
        this.status = status;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getSessionToken() { return sessionToken; }
    public String getStatus() { return status; }
    public String getName() { return name; }
    public boolean isSuccess() { return success; }
}
