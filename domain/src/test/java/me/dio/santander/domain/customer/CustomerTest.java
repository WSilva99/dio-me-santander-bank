package me.dio.santander.domain.customer;

import me.dio.santander.domain.Address;
import me.dio.santander.domain.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void givenAValidParams_whenCreateACustomer_thenReturnACustomerCreated() {

        // Given
        final var expectedName = "John Doe";
        final var expectedPhone = "123456789";
        final var expectedEmail = "john.doe@email.com";
        final var expectedAddress = "Rua dos Bobos 123, São Paulo, SP, 01234-567";

        final var anEmail = Email.of(expectedEmail);

        final var anAddress = Address.of(
                "Rua dos Bobos",
                "123",
                "São Paulo",
                "SP",
                "01234-567"
        );

        // When
        final var customer = Customer
                .of(expectedName, expectedPhone,anEmail, anAddress);

        // Then
        assertEquals(expectedName, customer.name());
        assertEquals(expectedPhone, customer.phone());
        assertEquals(expectedEmail, customer.email().value());
        assertEquals(expectedAddress, customer.address().toString());
        assertNotNull(customer.createdAt());
        assertNotNull(customer.updatedAt());

    }

    @Test
    void givenAInvalidNameNull_whenCreateACustomer_thenThrowIllegalArgumentException() {

        // Given
        final var aPhone = "123456789";
        final var anEmail = Email.of("john.doe@email.com");
        final var anAddress = Address.of(
                "Rua dos Bobos",
                "123",
                "São Paulo",
                "SP",
                "01234-567"
        );

        final var expecterErrorMessage = "Name is required";

        // When
        final Executable command = () -> Customer.of(null, aPhone,anEmail, anAddress);

        // Then
        final var error = assertThrows(IllegalArgumentException.class, command);
        assertEquals(expecterErrorMessage, error.getMessage());

    }

    @Test
    void givenAInvalidNameEmpty_whenCreateACustomer_thenThrowIllegalArgumentException() {

        // Given
        final var aPhone = "123456789";
        final var anEmail = Email.of("john.doe@email.com");
        final var anAddress = Address.of(
                "Rua dos Bobos",
                "123",
                "São Paulo",
                "SP",
                "01234-567"
        );

        final var expecterErrorMessage = "Name is required";

        // When
        final Executable command = () -> Customer.of("       ", aPhone, anEmail, anAddress);

        // Then
        final var error = assertThrows(IllegalArgumentException.class, command);
        assertEquals(expecterErrorMessage, error.getMessage());

    }
}