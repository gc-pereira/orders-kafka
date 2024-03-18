package edu.example.orders.models.reposity;

import edu.example.orders.models.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
