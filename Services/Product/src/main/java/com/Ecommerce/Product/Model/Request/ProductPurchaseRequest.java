package com.Ecommerce.Product.Model.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "ProductId is required")
        Integer productId,
        @Positive(message = "Quantity is mandatory and must be greater than zero")
        Integer quantity
) {
}
