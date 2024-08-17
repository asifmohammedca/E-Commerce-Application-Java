package com.Ecommerce.Payment.Model.Request;

import com.Ecommerce.Payment.Model.Enum.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String firstName,
        String lastName,
        String email) {
}
