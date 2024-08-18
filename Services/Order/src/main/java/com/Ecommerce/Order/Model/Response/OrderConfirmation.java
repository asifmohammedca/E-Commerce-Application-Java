package com.Ecommerce.Order.Model.Response;

import com.Ecommerce.Order.Model.Enum.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<PurchaseResponse> products

) {
}
