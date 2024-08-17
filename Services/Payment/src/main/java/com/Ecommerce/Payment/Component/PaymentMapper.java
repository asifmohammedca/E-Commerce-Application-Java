package com.Ecommerce.Payment.Component;

import com.Ecommerce.Payment.Model.Entity.Payment;
import com.Ecommerce.Payment.Model.Request.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment toPayment(PaymentRequest paymentRequest) {
        if (paymentRequest == null) {
            return null;
        }
        return Payment.builder()
                .id(paymentRequest.id())
                .paymentMethod(paymentRequest.paymentMethod())
                .amount(paymentRequest.amount())
                .orderId(paymentRequest.orderId())
                .build();
    }
}
