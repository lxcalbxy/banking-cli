package lv.v3nom.application.dto.responses;

public class CustomerResponse {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String status;

    public CustomerResponse() {}
    public CustomerResponse(String customerId,
                            String name,
                            String email,
                            String phone,
                            String status) {

        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getStatus() { return status; }
}
