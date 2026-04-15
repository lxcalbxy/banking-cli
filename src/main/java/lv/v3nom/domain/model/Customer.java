package lv.v3nom.domain.model;

import lv.v3nom.domain.value.CustomerId;
import lv.v3nom.domain.value.EmailAddress;
import lv.v3nom.domain.value.PhoneNumber;
import lv.v3nom.infrastructure.util.IdGenerator;
import lv.v3nom.infrastructure.util.impl.SystemDateTimeProvider;

import java.time.LocalDateTime;

public class Customer {
    private final CustomerId id;
    private String name;
    private EmailAddress email;
    private PhoneNumber phoneNumber;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Customer(CustomerId id,
                     String name,
                     EmailAddress email,
                     PhoneNumber phoneNumber,
                     LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public static Customer register(String name,
                                    String email,
                                    String phone) {
        return new Customer(
                CustomerId.generate(),
                name.trim(),
                EmailAddress.of(email),
                PhoneNumber.of(phone),
                new SystemDateTimeProvider().now());
    }
    public static Customer reconstitute(CustomerId id,
                                       String name,
                                       EmailAddress email,
                                       PhoneNumber phoneNumber,
                                       LocalDateTime createdAt,
                                       LocalDateTime updatedAt) {
        Customer customer = new Customer(
                id, name, email, phoneNumber, createdAt);
        customer.updatedAt = updatedAt;
        return customer;
    }
    // TODO
    // - void changeName
    public void changeName(String newName) {
        if (newName.isBlank() || newName == null) {
            throw new IllegalArgumentException(
                    "New customer name cannot be blank or null");
        }
        if (newName.length() < 3 || newName.length() > 45) {
            throw new IllegalArgumentException(
                    "Exceptional name length: " + newName.length()
                            + String.format(". Allowed name length from %s to %s characters.", 3, 45));
        }
        this.name = newName;
    }
    // - void changeEmail
    public void changeEmail(EmailAddress newEmail) {
        if (newEmail == null) {
            throw new IllegalArgumentException("New email cannot be null");
        }
        if (newEmail.equals(this.email)) {
            throw new IllegalArgumentException("New email cannot be same");
        }
        this.email = newEmail;
    }
    // - void changePhoneNumber
    public void changePhoneNumber(PhoneNumber newPhoneNumber) {
        if (newPhoneNumber == null) {
            throw new IllegalArgumentException("New phone number cannot be null");
        }
        if (newPhoneNumber.equals(this.phoneNumber)) {
            throw new IllegalArgumentException("New phone number cannot be same");
        }
        this.phoneNumber = newPhoneNumber;
    }

    // query
    // - bool canOpenAccount
    public boolean canOpenAccount() {

    }

    public CustomerId getId() { return id; }
    public String getName() { return name; }
    public EmailAddress getEmail() { return email; }
    public PhoneNumber getPhoneNumber() { return phoneNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
