package edu.example.orders.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = Person.TABLE_NAME)
public class Person {

    public static final String TABLE_NAME = "person";

    @Id
    @NotNull
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @NotEmpty
    @NotNull
    @Column(name = "name", nullable = false)
    public String name;

    @NotEmpty
    @NotNull
    @Column(name = "birth_date", nullable = false)
    public Timestamp birth_date;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "document_id")
    public Document document;

    @Column(name = "phone")
    public String phone;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public Address address;

    @NotNull
    @NotEmpty
    @Column(name = "age")
    public Integer age;

    @Column(name = "occupation")
    public String occupation;

    @Column(name = "email")
    public String email;

}
