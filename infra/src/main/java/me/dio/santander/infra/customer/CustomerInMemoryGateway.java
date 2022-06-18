package me.dio.santander.infra.customer;

import me.dio.santander.domain.customer.Customer;
import me.dio.santander.domain.customer.CustomerGateway;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerInMemoryGateway implements CustomerGateway {

    private final static HashMap<String, CustomerModel> customers = new HashMap<>();

    @Override
    public Customer create(Customer customer) {
        final var id = UUID.randomUUID().toString();

        customers.put(id, new CustomerModel(
                id,
                customer.name(),
                customer.email().value(),
                customer.phone(),
                customer.address()
        ));

        return customers.get(id).toDomain();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customers.get(id)).map(CustomerModel::toDomain);
    }

}
