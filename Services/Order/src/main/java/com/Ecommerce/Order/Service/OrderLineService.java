package com.Ecommerce.Order.Service;

import com.Ecommerce.Order.Component.OrderLineMapper;
import com.Ecommerce.Order.Model.Request.OrderLineRequest;
import com.Ecommerce.Order.Model.Response.OrderLineResponse;
import com.Ecommerce.Order.Repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineMapper orderLineMapper;
    private final OrderLineRepository orderLineRepository;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = orderLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
