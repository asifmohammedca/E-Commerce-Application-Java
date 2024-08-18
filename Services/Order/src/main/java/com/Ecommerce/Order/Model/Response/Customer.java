package com.Ecommerce.Order.Model.Response;

public record Customer(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
