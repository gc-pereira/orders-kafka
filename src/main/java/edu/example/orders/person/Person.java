package edu.example.orders.person;

import edu.example.orders.address.Address;
import edu.example.orders.document.Document;

public record Person(Integer id,
                     String name,
                     String birth_date,
                     Document document,
                     String phone,
                     Address address,
                     Integer age,
                     String occupation,
                     String email) {
}
