package me.dio.santander.domain.account;

import java.math.BigDecimal;

public class PaymentAccount extends Account {

    private PaymentAccount(String id, String password, BigDecimal balance, String number, String customerId) {
        super(id, password, balance, number, customerId, Type.CHECKING);

        this.validate();
    }

    static PaymentAccount of(
            final String password,
            final BigDecimal balance,
            final String number,
            final String customerId
    ) {
        return new PaymentAccount(null, password, balance, number, customerId);
    }

    @Override
    public void transfer(Account anAccount, BigDecimal anAmount) {
        throw new UnsupportedOperationException("Not supported this.");
    }

    @Override
    public void validate() {
        if (this.balance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

}
