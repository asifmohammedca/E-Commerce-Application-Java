package com.Ecommerce.Order.Component;

import com.Ecommerce.Order.Model.Entity.Order;
import com.Ecommerce.Order.Model.Entity.OrderLine;
import com.Ecommerce.Order.Model.Request.OrderLineRequest;
import com.Ecommerce.Order.Model.Response.OrderLineResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.orderId())
                .productId(orderLineRequest.productID())
                .order(
                        Order.builder()
                                .id(orderLineRequest.orderId())
                                .build()
                )
                .quantity(orderLineRequest.quantity())
                .build();    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
