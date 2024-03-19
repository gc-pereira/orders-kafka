package edu.example.orders.transfer;

import jakarta.validation.constraints.NotBlank;

public record DocumentData(
        @NotBlank
        String type,
        @NotBlank
        String number) {
}
