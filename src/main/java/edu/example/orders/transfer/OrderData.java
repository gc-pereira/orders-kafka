package edu.example.orders.transfer;

import java.sql.Timestamp;

public record OrderData(Timestamp date,
                        PersonData person,
                        ShopData shop,
                        ProductData product) {
}
