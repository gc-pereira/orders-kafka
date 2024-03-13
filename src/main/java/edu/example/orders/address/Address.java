package edu.example.orders.address;

public record Address(String street_name,
                      String number,
                      String complement,
                      String post_code,
                      String uf,
                      String city) {
}
