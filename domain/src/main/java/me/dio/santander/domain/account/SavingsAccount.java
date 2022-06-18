package me.dio.santander.domain.account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    private SavingsAccount(
            final String id,
            final String password,
            final BigDecimal balance,
            final String number,
            final String customerId
    ) {

        super(id,password, balance, number, customerId, Type.SAVINGS);
        this.validate();

    }

    static SavingsAccount of(
            final String password,
            final BigDecimal balance,
            final String number,
            final String customerId) {

        return new SavingsAccount(null, password, balance, number, customerId);

    }

    @Override
    public void validate() {

        if (this.balance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

    }

}
