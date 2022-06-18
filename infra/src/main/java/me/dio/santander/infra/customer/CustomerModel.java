package me.dio.santander.infra.customer;

import me.dio.santander.domain.Address;
import me.dio.santander.domain.customer.Customer;

public record CustomerModel(String id, String name, String email, String phone, Address address) {

    public Customer toDomain() {
        return Customer.of(
                id(),
                name(),
                phone(),
                email(),
                address()
            );
    }

}
