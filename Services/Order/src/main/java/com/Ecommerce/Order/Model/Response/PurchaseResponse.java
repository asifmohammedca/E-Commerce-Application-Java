package com.Ecommerce.Order.Model.Response;

import java.math.BigDecimal;

public record PurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        Integer quantity
) {
}
