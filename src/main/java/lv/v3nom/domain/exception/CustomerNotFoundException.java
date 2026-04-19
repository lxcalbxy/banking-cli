package lv.v3nom.domain.exception;

import lv.v3nom.domain.value.CustomerId;
import lv.v3nom.domain.value.CustomerStatus;
import lv.v3nom.domain.value.EmailAddress;
import lv.v3nom.domain.value.PhoneNumber;

import java.util.Optional;

public class CustomerNotFoundException extends RuntimeException {
    private final CustomerId customerId;
    private final EmailAddress emailAddress;
    private final PhoneNumber phoneNumber;
    private final CustomerStatus customerStatus;

    public CustomerNotFoundException() {
        super("Customers not found");
        this.customerId = null;
        this.emailAddress = null;
        this.phoneNumber = null;
        this.customerStatus = null;
    }
    public CustomerNotFoundException(CustomerId customerId) {
        super(String.format("Customer not found with Customer ID=[%s]", customerId.getValue()));
        this.customerId = customerId;
        this.emailAddress = null;
        this.phoneNumber = null;
        this.customerStatus = null;
    }
    public CustomerNotFoundException(EmailAddress emailAddress) {
        super(String.format("Customer not found with Email=[%s]", emailAddress.getValue()));
        this.customerId = null;
        this.emailAddress = emailAddress;
        this.phoneNumber = null;
        this.customerStatus = null;
    }
    public CustomerNotFoundException(PhoneNumber phoneNumber) {
        super(String.format("Customer not found with Phone=[%s]", phoneNumber.getValue()));
        this.customerId = null;
        this.emailAddress = null;
        this.phoneNumber = phoneNumber;
        this.customerStatus = null;
    }
    public CustomerNotFoundException(CustomerStatus customerStatus) {
        super(String.format("Customer not found with Status=[%s]", customerStatus.getValue()));
        this.customerId = null;
        this.emailAddress = null;
        this.phoneNumber = null;
        this.customerStatus = customerStatus;
    }

    public CustomerId getCustomerId() { return customerId; }
    public EmailAddress getEmailAddress() { return emailAddress; }
    public PhoneNumber getPhoneNumber() { return phoneNumber; }
    public CustomerStatus getCustomerStatus() { return customerStatus; }
}
