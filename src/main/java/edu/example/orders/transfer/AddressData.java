package edu.example.orders.transfer;

public record AddressData(String street_name,
                          String number,
                          String complement,
                          String post_code,
                          String uf,
                          String city) {
}
