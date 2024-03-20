package edu.example.orders.transfer;

import edu.example.orders.models.entity.Person;
import edu.example.orders.models.entity.Product;
import edu.example.orders.models.entity.Shop;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;

public record OrderData(Timestamp date,
                        @NotNull
                        Long personId,
                        @NotNull
                        Long shopId,
                        @NotNull
                        List<Long> productId) {
}
