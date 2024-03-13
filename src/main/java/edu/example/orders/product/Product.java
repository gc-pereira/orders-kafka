package edu.example.orders.product;

public record Product(String name,
                      String brand,
                      String model_number,
                      String category,
                      String description,
                      String colors,
                      double price,
                      double weight,
                      String manufacturer,
                      int year_manufacturer) {
}
