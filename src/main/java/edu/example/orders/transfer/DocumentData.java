package edu.example.orders.transfer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DocumentData(
        @NotBlank
        String type,
        @NotBlank
        String number) {
}
