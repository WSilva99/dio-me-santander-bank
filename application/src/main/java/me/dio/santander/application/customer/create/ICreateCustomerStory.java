package me.dio.santander.application.customer.create;

import me.dio.santander.domain.Address;
import me.dio.santander.domain.customer.Customer;

public interface ICreateCustomerStory {

    CreateCustomerOut execute(CreateCustomerIn in);

    record CreateCustomerIn(String name, String email, String phone, CreateAddressIn address) {

    }

    record CreateCustomerOut(String id) {

        public static CreateCustomerOut of(Customer customer) {
            return new CreateCustomerOut(customer.id());
        }

    }

    record CreateAddressIn( String street, String number, String city, String state, String zip) {

        public Address toDomain() {
            return Address.of(
                    street(),
                    number(),
                    city(),
                    state(),
                    zip()
            );
        }

    }

}
