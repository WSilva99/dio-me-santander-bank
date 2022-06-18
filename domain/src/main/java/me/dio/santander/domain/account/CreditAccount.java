package me.dio.santander.domain.account;

import java.math.BigDecimal;

public class CreditAccount extends Account {

    private BigDecimal overdraftLimit;

    private CreditAccount(String id, String password, BigDecimal balance, String number, String customerId) {
        super(id, password, balance, number, customerId, Type.CREDIT);
        this.validate();
    }

    static CreditAccount of(String password, BigDecimal balance, String number, String customerId) {
        return new CreditAccount(null, password, balance, number, customerId);
    }

    public BigDecimal overdraftLimit() {
        return overdraftLimit;
    }

    public void Validate() {

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
