package edu.example.orders.shop;

import edu.example.orders.address.Address;

public record Shop(String name,
                   String ein,
                   String phone,
                   Address address,
                   String segment,
                   String email) {

}
