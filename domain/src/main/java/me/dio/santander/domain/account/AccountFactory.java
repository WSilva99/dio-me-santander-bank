package me.dio.santander.domain.account;

import java.math.BigDecimal;

public interface AccountFactory {

    static Account of(String password, BigDecimal balance, String number, String customerId, Account.Type type) {
        switch (type) {
            case CHECKING:
                return CheckingAccount.of(password, balance, number, customerId);
            case SAVINGS:
                return SavingsAccount.of(password, balance, number, customerId);
            case CREDIT:
                return CreditAccount.of(password, balance, number, customerId);
            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }

}
