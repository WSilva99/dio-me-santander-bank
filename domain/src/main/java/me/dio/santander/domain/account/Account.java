package me.dio.santander.domain.account;

import me.dio.santander.domain.Entity;

import java.math.BigDecimal;

import static java.time.Instant.now;

public abstract class Account extends Entity {

    private String password;
    private BigDecimal balance;
    private String number;
    private String customerId;
    private Type type;

    protected Account(
            final String id,
            final String password,
            final BigDecimal balance,
            final String number,
            final String customerId,
            final Type type ) {

        super(id);

        this.password = password;
        this.balance = balance;
        this.number = number;
        this.customerId = customerId;
        this.type = type;
        this.updatedAt = now();

        this.validate();

    }

    public void deposit(final BigDecimal anAmount) {
        this.balance = this.balance.add(anAmount);
        this.validate();
    }

    public void withdraw(BigDecimal anAmount) {
        this.balance = this.balance.subtract(anAmount);
        this.validate();
    }

    public void transfer(Account anAccount, BigDecimal anAmount) {
        this.balance = this.balance.subtract(anAmount);
        this.validate();

        anAccount.deposit(anAmount);
    }

    public void validate() {

        if (this.password == null) {
            throw new IllegalArgumentException("Password is required");
        }

        if (this.balance == null) {
            throw new IllegalArgumentException("Balance is required");
        }

        if (this.number == null) {
            throw new IllegalArgumentException("Number is required");
        }

        if (this.customerId == null) {
            throw new IllegalArgumentException("CustomerId is required");
        }

        if (this.type == null) {
            throw new IllegalArgumentException("Type is required");
        }

    }

    public BigDecimal balance() {
        return this.balance;
    }

    public String number() {
        return this.number;
    }

    public String customerId() {
        return this.customerId;
    }

    public Type type() {
        return this.type;
    }

    enum Type {
        CHECKING,
        SAVINGS,
        PAYMENT
    }

}
