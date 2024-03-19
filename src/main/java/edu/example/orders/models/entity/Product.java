package edu.example.orders.models.entity;


import edu.example.orders.transfer.ProductData;
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
    @Column(name = "id", unique = true)
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
    @Column(name = "price", nullable = false)
    public Double price;

    @NotNull
    @Column(name = "weight", nullable = false)
    public Double weight;

    @NotEmpty
    public String manufacturer;

    public Integer year_manufacturer;

    public Product(ProductData productData){
        this.name = productData.name();
        this.brand = productData.brand();
        this.model_number = productData.model_number();
        this.category = productData.category();
        this.description = productData.description();
        this.price = productData.price();
        this.weight = productData.weight();
        this.manufacturer = productData.manufacturer();
        this.year_manufacturer = productData.year_manufacturer();
    }

    protected Product() {}
}
