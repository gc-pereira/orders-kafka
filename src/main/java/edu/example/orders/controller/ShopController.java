package edu.example.orders.controller;


import edu.example.orders.models.entity.Shop;
import edu.example.orders.models.reposity.ShopRepository;
import edu.example.orders.transfer.ShopData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    public ShopRepository shopRepository;

    @PostMapping
    @Transactional
    public void createShop(@RequestBody @Valid ShopData shopData) {
        shopRepository.save(
                new Shop(
                        shopData
                )
        );
    }

    @GetMapping
    public @ResponseBody Optional<Shop> getShop(@RequestParam(name = "id") Long id) {
        return shopRepository.findById(id);
    }

    @GetMapping(value = "/id")
    public @ResponseBody List<Shop> getAllShops(){
        return shopRepository.findAll();
    }
}
