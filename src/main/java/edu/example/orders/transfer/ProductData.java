package edu.example.orders.transfer;

public record ProductData(String name,
                          String brand,
                          String model_number,
                          String category,
                          String description,
                          Double price,
                          Double weight,
                          String manufacturer,
                          Integer year_manufacturer) {
}
