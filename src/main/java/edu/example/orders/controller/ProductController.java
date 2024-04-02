package edu.example.orders.controller;

import edu.example.orders.message.ProducerMessage;
import edu.example.orders.models.entity.Product;
import edu.example.orders.models.reposity.ProductRepository;
import edu.example.orders.transfer.ProductData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    ProducerMessage producerMessage;

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody @Valid ProductData productData){
        System.out.println(productData.toString());
        productRepository.save(
                new Product(
                        productData
                )
        );
        producerMessage.setTopicName("PRODUCTS");
        producerMessage.setHeader("CREATE_PRODUCT");
        producerMessage.sendMessage(productData.toString());
    }

    @GetMapping
    public Optional<Product> getProduct(@RequestParam(value = "id") Long id) {
        return productRepository.findById(id);
    }

    @GetMapping(value = "/id")
    public @ResponseBody List<Product> getAllProducts(){
        return productRepository.findAll().stream().toList();
    }

    @DeleteMapping(value = "/id")
    public void deleteProduct(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        producerMessage.setTopicName("PRODUCTS");
        producerMessage.setHeader("DELETE_PRODUCT");
        producerMessage.sendMessage(productRepository.findById(id).toString());
    }
}
