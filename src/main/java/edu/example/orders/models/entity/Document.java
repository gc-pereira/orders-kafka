package edu.example.orders.models.entity;

import edu.example.orders.transfer.DocumentData;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Embeddable
public class Document {

    public String type;
    public String number;

    public Document(DocumentData documentData) {
        this.type = documentData.type();
        this.number = documentData.number();
    }

    public Document() {}
}
