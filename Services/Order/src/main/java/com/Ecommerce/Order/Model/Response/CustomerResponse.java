package com.Ecommerce.Order.Model.Response;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
