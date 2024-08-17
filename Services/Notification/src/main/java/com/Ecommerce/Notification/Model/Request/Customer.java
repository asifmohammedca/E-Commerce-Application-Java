package com.Ecommerce.Notification.Model.Request;

public record Customer(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
