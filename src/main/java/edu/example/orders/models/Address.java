package edu.example.orders.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = Address.TABLE_NAME)
public class Address {
    public static final String TABLE_NAME = "address";

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "street_name", length = 300, nullable = false)
    private String streetName;

    @Column(name = "complement", length = 100, nullable = true)
    private String complement;

    @Column(name = "post_code", nullable = false)
    private String postCode;

    @Column(name = "uf", nullable = false)
    private String uf;

    @Column(name = "city", nullable = false)
    private String city;

}
