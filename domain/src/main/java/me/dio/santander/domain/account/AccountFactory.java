package me.dio.santander.domain.account;

import java.math.BigDecimal;

public interface AccountFactory {

    static PaymentAccount ofPayment(
            final String password,
            final BigDecimal balance,
            final String number,
            final String customerId) {

        return PaymentAccount.of(password, balance, number, customerId);

    }

    static SavingsAccount ofSavings(
            final String password,
            final BigDecimal balance,
            final String number,
            final String customerId) {

        return SavingsAccount.of(password, balance, number, customerId);

    }

    static CheckingAccount ofChecking(
            final String password,
            final BigDecimal balance,
            final BigDecimal overdraftLimit,
            final String number,
            final String customerId) {

        return CheckingAccount.of(password, balance, overdraftLimit, number, customerId);

    }

}
