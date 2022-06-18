package me.dio.santander.infra.api.customer;

import me.dio.santander.application.customer.create.CreateCustomerStory;
import me.dio.santander.application.customer.create.ICreateCustomerStory;
import me.dio.santander.application.customer.find.by.id.FindCustomerByIdStory;
import me.dio.santander.application.customer.find.by.id.IFindCustomerByIdStory;
import me.dio.santander.domain.customer.CustomerGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class _CustomersBeans {

   private final CustomerGateway gateway;

    _CustomersBeans(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Bean
    ICreateCustomerStory createCustomerStory() {
        return new CreateCustomerStory(gateway);
    }

    @Bean
    IFindCustomerByIdStory findCustomerByIdStory() {
        return new FindCustomerByIdStory(gateway);
    }

}
