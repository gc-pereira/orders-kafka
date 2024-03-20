package edu.example.orders.models.entity;

import edu.example.orders.transfer.OrderData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = Order.TABLE_NAME)
public class Order {

    public static final String TABLE_NAME = "orders";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    public Long id;

    @NotNull
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

    public Order(Timestamp date, Person person, Shop shop, List<Product> product){
        this.date = date;
        this.person = person;
        this.shop = shop;
        this.product = product;
    }

    protected Order() {

    }
}
