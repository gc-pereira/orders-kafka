package edu.example.orders.models.entity;

import edu.example.orders.transfer.ShopData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = Shop.TABLE_NAME)
public class Shop {
    public static final String TABLE_NAME = "shop";

    @Id
    @NotEmpty
    @NotNull
    @Column(name = "id", nullable = false)
    public Long id;

    @NotNull
    @NotEmpty
    @Column(name = "name")
    public String name;

    @NotNull
    @NotEmpty
    @Column(name = "ein")
    public String ein;

    @NotEmpty
    public String phone;

    @Embedded
    public Address address;

    @NotEmpty
    public String segment;

    @NotNull
    @NotEmpty
    @Column(name = "email")
    public String email;

    public Shop(ShopData shopData) {
        this.name = shopData.name();
        this.ein = shopData.ein();
        this.phone = shopData.phone();
        this.address = new Address(shopData.address());
        this.segment = shopData.segment();
        this.email = shopData.email();
    }

    protected Shop() {}
}
