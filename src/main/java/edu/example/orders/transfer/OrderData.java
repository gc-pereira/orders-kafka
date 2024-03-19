package edu.example.orders.transfer;

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
