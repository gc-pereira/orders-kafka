package edu.example.orders.person;

import edu.example.orders.address.Address;
import edu.example.orders.document.Document;

public record Person(String name,
                     String birth_date,
                     Document document,
                     String phone,
                     Address address,
                     int age,
                     String occupation,
                     String email) {
}
