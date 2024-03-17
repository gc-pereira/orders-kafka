package edu.example.orders.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = Document.TABLE_NAME)
public class Document {

    public static final String TABLE_NAME = "document";

    @Id
    @NotEmpty
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @NotNull
    @NotEmpty
    @Column(name = "type", nullable = false)
    public String type;

    @NotNull
    @NotEmpty
    @Column(name = "number", nullable = false)
    public String number;
}
