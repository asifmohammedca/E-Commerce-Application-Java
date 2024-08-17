package com.Ecommerce.Notification.Model.Entity;

import com.Ecommerce.Notification.Model.Enum.NotificationType;
import com.Ecommerce.Notification.Model.Request.OrderConfirmation;
import com.Ecommerce.Notification.Model.Request.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
