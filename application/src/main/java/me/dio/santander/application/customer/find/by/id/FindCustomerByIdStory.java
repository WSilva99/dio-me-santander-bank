package me.dio.santander.application.customer.find.by.id;

import me.dio.santander.domain.customer.CustomerGateway;

public class FindCustomerByIdStory implements IFindCustomerByIdStory {

    private final CustomerGateway gateway;

    public FindCustomerByIdStory(final CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public FindCustomerByIdOut execute(String id) {
        return gateway.findById(id)
                .map(FindCustomerByIdOut::of)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}
