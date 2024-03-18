package edu.example.orders.models.reposity;

import edu.example.orders.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
