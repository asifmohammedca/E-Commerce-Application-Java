package com.Ecommerce.Notification.Kafka;

import com.Ecommerce.Notification.Email.EmailService;
import com.Ecommerce.Notification.Model.Entity.Notification;
import com.Ecommerce.Notification.Model.Request.OrderConfirmation;
import com.Ecommerce.Notification.Model.Request.PaymentConfirmation;
import com.Ecommerce.Notification.Repository.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.Ecommerce.Notification.Model.Enum.NotificationType.ORDER_CONFIRMATION;
import static com.Ecommerce.Notification.Model.Enum.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationListener {
    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Listen message from payment-topic Topic:: %s", paymentConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerName = paymentConfirmation.firstName() + " " + paymentConfirmation.lastName();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.email(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotifications(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        var customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }


}
