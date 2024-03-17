package edu.example.orders.models;

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
    public String id;

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

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "address_id")
    public Address address;

    @NotEmpty
    public String segment;

    @NotNull
    @NotEmpty
    @Column(name = "email")
    public String email;
}
