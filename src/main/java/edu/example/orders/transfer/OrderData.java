package edu.example.orders.transfer;

import java.sql.Timestamp;
import java.util.List;

public record OrderData(Timestamp date,
                        Long personId,
                        Long shopId,
                        List<Long> productId) {
}
