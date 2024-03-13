package edu.example.orders.order;

import edu.example.orders.person.Person;
import edu.example.orders.product.Product;
import edu.example.orders.shop.Shop;

public record Order(String date,
                    Person person,
                    Shop shop,
                    Product product) {
}
