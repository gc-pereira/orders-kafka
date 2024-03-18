package edu.example.orders.models.entity;

import edu.example.orders.transfer.AddressData;
import lombok.Getter;
import jakarta.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String streetName;
    private String complement;
    private String postCode;
    private String uf;
    private String city;

    public Address(String streetName, String complement, String postCode, String uf, String city) {
        this.streetName = streetName;
        this.complement = complement;
        this.postCode = postCode;
        this.uf = uf;
        this.city = city;
    }

}
