package me.dio.santander.domain.bankbranch;

import me.dio.santander.domain.Address;
import me.dio.santander.domain.Entity;

import static java.time.Instant.now;

public class BankBranch extends Entity {

    private String name;
    private String number;
    private String phone;
    private Address address;

    private BankBranch(
            final String id,
            final String name,
            final String number,
            final String phone,
            final Address address
    ) {

        super(id);

        this.name = name;
        this.number = number;
        this.phone = phone;
        this.address = address;

        this.updatedAt = now();

        this.validate();

    }

    public static BankBranch of(
            final String name,
            final String number,
            final String phone,
            final Address address
    ) {

        return new BankBranch(
                null,
                name,
                number,
                phone,
                address
        );

    }

    public BankBranch update(
            final String name,
            final String number,
            final String phone,
            final Address address
    ) {

        this.name = name;
        this.number = number;
        this.phone = phone;
        this.address = address;
        this.updatedAt = now();

        this.validate();

        return this;

    }

    @Override
    public void validate() {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Number is required");
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

    public String number() {
        return number;
    }

    public String phone() {
        return phone;
    }

    public Address address() {
        return address;
    }

}
