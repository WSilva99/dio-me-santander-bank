package me.dio.santander.infra.api.customer;

import me.dio.santander.application.customer.create.ICreateCustomerStory;
import me.dio.santander.application.customer.create.ICreateCustomerStory.CreateCustomerIn;
import me.dio.santander.application.customer.find.by.id.IFindCustomerByIdStory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements ICustomerController {

    private final ICreateCustomerStory createCustomerStory;
    private final IFindCustomerByIdStory findCustomerByIdStory;

    public CustomerController(
            final ICreateCustomerStory createCustomerStory,
            final IFindCustomerByIdStory findCustomerByIdStory) {

        this.createCustomerStory = createCustomerStory;
        this.findCustomerByIdStory = findCustomerByIdStory;
    }

    @Override
    public ICreateCustomerStory.CreateCustomerOut create(final CreateCustomerIn in) {
        return createCustomerStory.execute(in);
    }

    @Override
    public IFindCustomerByIdStory.FindCustomerByIdOut findById(final String customerId) {
        return findCustomerByIdStory.execute(customerId);
    }

}
