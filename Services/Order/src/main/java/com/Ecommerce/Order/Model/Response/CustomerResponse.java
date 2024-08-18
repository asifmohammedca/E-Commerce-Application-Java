package com.Ecommerce.Order.Model.Response;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
