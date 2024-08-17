package com.Ecommerce.Order.Model.Request;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productID,
        Integer quantity) {
}
