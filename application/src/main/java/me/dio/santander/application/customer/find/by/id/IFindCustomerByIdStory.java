package me.dio.santander.application.customer.find.by.id;

import me.dio.santander.domain.customer.Customer;

public interface IFindCustomerByIdStory {

    FindCustomerByIdOut execute(String id);

    record FindCustomerByIdOut(String id, String name, String email, String phone, String address) {


        public static FindCustomerByIdOut of(Customer customer) {
            return new FindCustomerByIdOut(
                    customer.id(),
                    customer.name(),
                    customer.email().toString(),
                    customer.phone(),
                    customer.address().toString()
            );
        }

    }


}
