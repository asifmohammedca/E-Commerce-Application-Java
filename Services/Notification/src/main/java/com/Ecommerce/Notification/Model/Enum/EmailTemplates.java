package com.Ecommerce.Notification.Model.Enum;

import lombok.Getter;

public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order.html", "Order confirmation");

    @Getter
    private final String template;
    @Getter
    private final String subject;


    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
