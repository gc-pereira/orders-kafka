package edu.example.orders.controller;

import edu.example.orders.models.entity.Order;
import edu.example.orders.models.entity.Person;
import edu.example.orders.models.entity.Product;
import edu.example.orders.models.entity.Shop;
import edu.example.orders.models.reposity.OrderRepository;
import edu.example.orders.models.reposity.PersonRepository;
import edu.example.orders.models.reposity.ProductRepository;
import edu.example.orders.models.reposity.ShopRepository;
import edu.example.orders.transfer.OrderData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public void createOrder(@RequestBody @Valid OrderData orderData) {
        Optional<Person> person = personRepository.findById(orderData.personId());
        Optional<Shop> shop = shopRepository.findById(orderData.shopId());
        List<Product> productList = productRepository.findAllById(orderData.productId());
        orderRepository.save(
                new Order(orderData.date(),
                        person.get(),
                        shop.get(),
                        productList)
        );
    }
}
