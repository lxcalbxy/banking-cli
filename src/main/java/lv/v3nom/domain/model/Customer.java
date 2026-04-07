package lv.v3nom.domain.model;

import lv.v3nom.domain.value.CustomerId;
import lv.v3nom.domain.value.EmailAddress;
import lv.v3nom.domain.value.PhoneNumber;

import java.time.LocalDateTime;

public class Customer {
    private CustomerId id;
    private String name;
    private EmailAddress email;
    private PhoneNumber phoneNumber;
    private LocalDateTime createdAt;
}
