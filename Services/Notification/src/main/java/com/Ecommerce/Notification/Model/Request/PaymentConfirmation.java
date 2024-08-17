package com.Ecommerce.Notification.Model.Request;

import com.Ecommerce.Notification.Model.Enum.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String firstName,
        String lastName,
        String email
) {
}
