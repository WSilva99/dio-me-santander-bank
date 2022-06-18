package me.dio.santander.domain.bankbranch;

import me.dio.santander.domain.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankBranchTest {

    @Test
    void givenAValidParams_whenCallOf_thenReturnABankBranchCreated() {

        // Given
        final var expectedName = "Santander: São Paulo";
        final var expectedNumber = "12345";
        final var expectedPhone = "+5511999999999";
        final var expectedAddress = "Rua dos Bobos 123, São Paulo, SP, 01234-567";

        final var anAddress = Address.of(
                "Rua dos Bobos",
                "123",
                "São Paulo",
                "SP",
                "01234-567"
        );

        // When
        final var bankBranch = BankBranch
                .of(expectedName, expectedNumber, expectedPhone, anAddress);

        // Then
        assertEquals(expectedName, bankBranch.name());
        assertEquals(expectedNumber, bankBranch.number());
        assertEquals(expectedPhone, bankBranch.phone());
        assertEquals(expectedAddress, bankBranch.address().toString());
        assertNotNull(bankBranch.createdAt());
        assertNotNull(bankBranch.updatedAt());

    }

    @Test
    void givenAValidParams_whenCallUpdate_thenReturnABankBranchUpdated() throws InterruptedException {

        // Given
        final var anAddress = Address.of(
                "Rua dos Bobos",
                "123",
                "São Paulo",
                "SP",
                "01234-567"
        );

        final var bankBranch = BankBranch
                .of("Santander: São Paulo", "12345", "+5511999999999", anAddress);

        final var createdAt = bankBranch.createdAt();
        final var updatedAt = bankBranch.updatedAt();

        // Para o caso de proceessadores muito rápidos
        Thread.sleep(1);

        final var expectedNameUpdated = "Santander: São Paulo";
        final var expectedNumberUpdated = "12345";
        final var expectedPhoneUpdated = "+5511998999896";
        final var expectedAddressUpdated = "Rua dos Bobos 124, São Paulo, SP, 01234-567";

        final var anAddressUpdated = Address.of(
                "Rua dos Bobos",
                "124",
                "São Paulo",
                "SP",
                "01234-567"
        );

        // When
        final var bankBranchUpdated = bankBranch
                .update(expectedNameUpdated, expectedNumberUpdated, expectedPhoneUpdated, anAddressUpdated);

        // Then
        assertEquals(expectedNameUpdated, bankBranchUpdated.name());
        assertEquals(expectedNumberUpdated, bankBranchUpdated.number());
        assertEquals(expectedPhoneUpdated, bankBranchUpdated.phone());
        assertEquals(expectedAddressUpdated, bankBranchUpdated.address().toString());
        assertEquals(createdAt, bankBranchUpdated.createdAt());
        assertTrue(bankBranchUpdated.updatedAt().isAfter(updatedAt));

    }


}