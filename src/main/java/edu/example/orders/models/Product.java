package edu.example.orders.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = Product.TABLE_NAME)
public class Product {

    public static final String TABLE_NAME = "product";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @NotEmpty
    @NotNull
    @Column(name = "name", nullable = false)
    public String name;

    @NotEmpty
    @Column(name = "brand")
    public String brand;

    @Column(name = "model_number", nullable = false)
    @NotNull
    public String model_number;

    @Column(name = "category")
    @NotEmpty
    public String category;

    @NotEmpty
    public String description;

    @NotNull
    @NotEmpty
    @Column(name = "price", nullable = false)
    public Double price;

    @NotNull
    @NotEmpty
    @Column(name = "weight", nullable = false)
    public Double weight;

    @NotEmpty
    public String manufacturer;

    @NotEmpty
    public Integer year_manufacturer;
}
