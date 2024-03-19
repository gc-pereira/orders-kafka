package edu.example.orders.models.entity;

import edu.example.orders.transfer.OrderData;
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
    public Long person_id;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    public Long shop_id;

    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public List<Product> product;

    public Order(OrderData orderData){
        this.date = orderData.date();
        this.person_id = orderData.personId();

    }

    protected Order() {

    }
}
