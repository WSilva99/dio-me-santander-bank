package me.dio.santander.infra.api.customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.santander.application.customer.create.ICreateCustomerStory.CreateCustomerIn;
import me.dio.santander.application.customer.create.ICreateCustomerStory.CreateCustomerOut;
import me.dio.santander.application.customer.find.by.id.IFindCustomerByIdStory.FindCustomerByIdOut;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/customers")
@Tag(name = "Customer")
public interface ICustomerController {

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid customer"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    CreateCustomerOut create(@RequestBody CreateCustomerIn in);

    @GetMapping(
            value = "{customerId}"
    )
    @Operation(summary = "Find a customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    FindCustomerByIdOut findById(@PathVariable String customerId);

}
