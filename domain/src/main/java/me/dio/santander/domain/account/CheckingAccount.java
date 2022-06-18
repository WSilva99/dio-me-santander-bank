package me.dio.santander.domain.account;

import java.math.BigDecimal;

public class CheckingAccount extends Account {

    private BigDecimal overdraftLimit;

    private CheckingAccount(String id, String password, BigDecimal balance, BigDecimal overdraftLimit, String number, String customerId) {
        super(id, password, balance, number, customerId, Type.PAYMENT);
        this.overdraftLimit = overdraftLimit;

        this.validate();
    }

    static CheckingAccount of(String password, BigDecimal balance, BigDecimal overdraftLimit, String number, String customerId) {
        return new CheckingAccount(null, password, balance, overdraftLimit, number, customerId);
    }

    public BigDecimal overdraftLimit() {
        return overdraftLimit;
    }

    public void validate() {

        if(overdraftLimit == null) {
            throw new IllegalArgumentException("Overdraft limit is required");
        }

        if(overdraftLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }

        final var limit = balance().add(overdraftLimit);

        if (limit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Limit is unavailable");
        }

    }

}
