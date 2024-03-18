package edu.example.orders.models.reposity;

import edu.example.orders.models.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
