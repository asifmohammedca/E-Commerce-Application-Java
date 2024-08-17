package com.Ecommerce.Notification.Model.Request;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        Integer quantity
) {
}
