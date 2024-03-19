package edu.example.orders.transfer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressData(
        @NotBlank
        @NotNull
        String street_name,
        @NotBlank
        @NotNull
        String number,
        @NotBlank
        String complement,
        @NotBlank
        @NotNull
        String post_code,
        @NotBlank
        @NotNull
        String uf,
        @NotBlank
        @NotNull
        String city) {
}
