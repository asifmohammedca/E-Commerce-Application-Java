package com.Ecommerce.Payment.Model.Request;

import com.Ecommerce.Payment.Model.Enum.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
