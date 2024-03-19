package edu.example.orders.controller;

import edu.example.orders.models.reposity.OrderRepository;
import edu.example.orders.transfer.OrderData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public void createOrder(@RequestBody @Valid OrderData orderData) {
        System.out.println(orderData);
    }
}
