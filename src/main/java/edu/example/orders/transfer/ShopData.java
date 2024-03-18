package edu.example.orders.transfer;

public record ShopData(String name,
                       String ein,
                       String phone,
                       AddressData address,
                       String segment,
                       String email) {

}
