package edu.example.orders.controller;

import edu.example.orders.message.ProducerMessage;
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

    ProducerMessage producerMessage;

    @PostMapping
    public void createOrder(@RequestBody @Valid OrderData orderData) {
        Optional<Person> person = personRepository.findById(orderData.personId());
        Optional<Shop> shop = shopRepository.findById(orderData.shopId());
        List<Product> productList = productRepository.findAllById(orderData.productId());
        Order order = new Order(orderData.date(),
                person.get(),
                shop.get(),
                productList);
        orderRepository.save(
                order
        );
        producerMessage.setTopicName("ORDERS");
        producerMessage.setHeader("CREATE_ORDER");
        producerMessage.sendMessage(order.toString());
    }

    @DeleteMapping(value = "/id")
    public void deleteOrder(@RequestParam(name = "id") Long id){
        orderRepository.deleteById(id);
        producerMessage.setTopicName("ORDERS");
        producerMessage.setHeader("DELETE_ORDER");
        producerMessage.sendMessage(orderRepository.findById(id).toString());
    }

    public @ResponseBody Optional<Order> getOrderById(@RequestParam(name = "id") Long id){
        return orderRepository.findById(id);
    }

}
