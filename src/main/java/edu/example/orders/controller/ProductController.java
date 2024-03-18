package edu.example.orders.controller;

import edu.example.orders.models.entity.Product;
import edu.example.orders.models.reposity.ProductRepository;
import edu.example.orders.transfer.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody ProductData productData){
        System.out.println(productData.toString());
        productRepository.save(
                new Product(
                        productData
                )
        );
    }
}
