package edu.example.orders.transfer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductData(@NotNull @NotBlank String name,
                          @NotNull @NotBlank String brand,
                          @NotBlank String model_number,
                          @NotBlank String category,
                          @NotBlank String description,
                          @NotNull Double price,
                          Double weight,
                          @NotBlank String manufacturer,
                          Integer year_manufacturer) {
}
