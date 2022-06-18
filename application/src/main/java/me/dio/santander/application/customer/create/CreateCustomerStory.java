package me.dio.santander.application.customer.create;

import me.dio.santander.domain.Email;
import me.dio.santander.domain.customer.Customer;
import me.dio.santander.domain.customer.CustomerGateway;

public class CreateCustomerStory implements ICreateCustomerStory {

    private final CustomerGateway gateway;

    public CreateCustomerStory(final CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CreateCustomerOut execute(CreateCustomerIn in) {

        final var customer = Customer.of(
                in.name(),
                in.phone(),
                Email.of(in.email()),
                in.address().toDomain()
        );

        return CreateCustomerOut.of(gateway.create(customer));
    }

}
