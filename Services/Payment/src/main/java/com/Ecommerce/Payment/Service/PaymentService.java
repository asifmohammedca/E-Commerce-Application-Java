package com.Ecommerce.Payment.Service;

import com.Ecommerce.Payment.Component.PaymentMapper;
import com.Ecommerce.Payment.Model.Request.PaymentNotificationRequest;
import com.Ecommerce.Payment.Model.Request.PaymentRequest;
import com.Ecommerce.Payment.Notification.NotificationProducer;
import com.Ecommerce.Payment.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );
        return payment.getId();
    }
}
