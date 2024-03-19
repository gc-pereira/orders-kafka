package edu.example.orders.transfer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record PersonData(
        @NotNull
        @NotBlank
        String name,
        Timestamp birth_date,
        @Valid
        DocumentData document,
        String phone,
        @NotNull
        @Valid
        AddressData address,
        Integer age,
        @NotBlank
        String occupation,
        @NotBlank
        @Email
        String email) {
}
