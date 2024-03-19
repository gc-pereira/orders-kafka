package edu.example.orders.models.entity;


import edu.example.orders.transfer.PersonData;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @NotEmpty
    @NotNull
    @Column(name = "name", nullable = false)
    public String name;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    public Timestamp birth_date;

    @Embedded
    public Document document;

    @Column(name = "phone")
    public String phone;

    @Embedded
    public Address address;

    @NotNull
    @Column(name = "age")
    public Integer age;

    @Column(name = "occupation")
    public String occupation;

    @Column(name = "email")
    public String email;

    public Person(PersonData personData) {
        this.name = personData.name();
        this.birth_date = personData.birth_date();
        this.document = new Document(personData.document());
        this.phone = personData.phone();
        this.address = new Address(personData.address());
        this.age = personData.age();
        this.occupation = personData.occupation();
        this.email = personData.email();
    }

    public Person() {}
}
