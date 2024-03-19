package edu.example.orders.models.entity;

import edu.example.orders.transfer.AddressData;
import lombok.Getter;
import jakarta.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    public String street_name;
    public String complement;
    public String postCode;
    public String uf;
    public String city;

    public Address(AddressData addressData) {
        this.street_name = addressData.street_name();
        this.complement = addressData.complement();
        this.postCode = addressData.post_code();
        this.uf = addressData.uf();
        this.city = addressData.city();
    }

    public Address() {
    }

}
