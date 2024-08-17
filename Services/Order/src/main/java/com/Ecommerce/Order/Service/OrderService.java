package com.Ecommerce.Order.Service;

import com.Ecommerce.Order.Client.CustomerClient;
import com.Ecommerce.Order.Client.PaymentClient;
import com.Ecommerce.Order.Client.ProductClient;
import com.Ecommerce.Order.Component.OrderMapper;
import com.Ecommerce.Order.Exception.BusinessException;
import com.Ecommerce.Order.Kafka.OrderProducer;
import com.Ecommerce.Order.Model.Request.OrderLineRequest;
import com.Ecommerce.Order.Model.Request.OrderRequest;
import com.Ecommerce.Order.Model.Request.PaymentRequest;
import com.Ecommerce.Order.Model.Request.PurchaseRequest;
import com.Ecommerce.Order.Model.Response.OrderConfirmation;
import com.Ecommerce.Order.Model.Response.OrderResponse;
import com.Ecommerce.Order.Model.Response.PurchaseResponse;
import com.Ecommerce.Order.Repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;


    @Transactional
    public Integer createOrder(OrderRequest orderRequest) {
        var customer = customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the ID"));

        var purchasedProducts = productClient.purchaseProducts(orderRequest.products());
        if(purchasedProducts.getStatusCode().isError()){
            throw new BusinessException("error occurred while processing the request");
        }

        var order = orderRepository.save(orderMapper.toOrder(orderRequest));

        for (PurchaseRequest purchaseRequest : orderRequest.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        var paymentRequest = new PaymentRequest(
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customer,
                        purchasedProducts.getBody()
                )
        );


        return order.getId();
    }

    public List<OrderResponse> findAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findByOrderId(Integer id) {
        return orderRepository.findById(id)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException("No order found"));
    }


}
