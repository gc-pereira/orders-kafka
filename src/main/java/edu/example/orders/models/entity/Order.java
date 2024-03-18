package edu.example.orders.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = Order.TABLE_NAME)
public class Order {

    public static final String TABLE_NAME = "orders";

    @Id
    @NotNull
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    public Long id;

    @NotNull
    @NotEmpty
    @Column(name = "date", nullable = false)
    public Timestamp date;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public Person person;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    public Shop shop;

    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public List<Product> product;

}
