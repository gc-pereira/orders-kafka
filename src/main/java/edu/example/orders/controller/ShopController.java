package edu.example.orders.controller;


import edu.example.orders.models.entity.Shop;
import edu.example.orders.models.reposity.ShopRepository;
import edu.example.orders.transfer.ShopData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    public ShopRepository shopRepository;

    @PostMapping
    @Transactional
    public void createShop(@RequestBody ShopData shopData) {
        shopRepository.save(
                new Shop(
                        shopData
                )
        );
    }
}
