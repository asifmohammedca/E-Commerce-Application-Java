package com.Ecommerce.Order.Component;

import com.Ecommerce.Order.Model.Entity.Order;
import com.Ecommerce.Order.Model.Request.OrderRequest;
import com.Ecommerce.Order.Model.Response.OrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest) {
        if (orderRequest == null) {
            return null;
        }
        return Order.builder()
                .id(orderRequest.id())
                .reference(orderRequest.reference())
                .paymentMethod(orderRequest.paymentMethod())
                .customerId(orderRequest.customerId())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
