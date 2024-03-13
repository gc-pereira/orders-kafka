package edu.example.orders.controller;

import edu.example.orders.order.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        System.out.println(order);
    }
}
