package me.dio.santander.domain.customer;

import me.dio.santander.domain.Address;
import me.dio.santander.domain.Email;
import me.dio.santander.domain.Entity;

import static java.time.Instant.now;

final public class Customer extends Entity {

    private String name;
    private String phone;
    private Email email;
    private Address address;

    private Customer(String id, String name, String phone, Email email, Address address) {

        super(id);

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;

        this.updatedAt = now();

        this.validate();

    }

    public static Customer of(final String name, final String phone, final Email email, final Address address) {

        return new Customer(
                null,
                name,
                phone,
                email,
                address
        );

    }

    public static Customer of(final String id, final String name, final String phone, final String email, final Address address) {

        return new Customer(
                id,
                name,
                phone,
                Email.of(email),
                address
        );

    }

    public Customer update(final String name, final String phone, final Email email, final Address address) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.updatedAt = now();

        this.validate();

        return this;

    }

    public void validate() {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone is required");
        }

        if (address == null) {
            throw new IllegalArgumentException("Address is required");
        }

    }

    public String name() {
        return name;
    }

    public Email email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public Address address() {
        return address;
    }

}
