package edu.example.orders.transfer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ShopData(String name,
                       String ein,
                       String phone,
                       @Valid AddressData address,
                       String segment,
                       String email) {

}
