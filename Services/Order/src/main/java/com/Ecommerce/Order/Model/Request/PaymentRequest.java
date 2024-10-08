package com.Ecommerce.Order.Model.Request;

import com.Ecommerce.Order.Model.Enum.PaymentMethod;
import com.Ecommerce.Order.Model.Response.Customer;

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
