package edu.example.orders.transfer;

import java.sql.Timestamp;

public record PersonData(Integer id,
                         String name,
                         Timestamp birth_date,
                         DocumentData document,
                         String phone,
                         AddressData address,
                         Integer age,
                         String occupation,
                         String email) {
}
