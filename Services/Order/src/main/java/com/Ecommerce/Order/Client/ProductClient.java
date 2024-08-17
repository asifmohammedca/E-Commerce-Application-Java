package com.Ecommerce.Order.Client;

import com.Ecommerce.Order.Model.Request.PurchaseRequest;
import com.Ecommerce.Order.Model.Response.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "product-service",
        url = "${application.config.product-url}"
)
public interface ProductClient {
    @PostMapping("/purchase")
    ResponseEntity<List<PurchaseResponse>> purchaseProducts(@RequestBody List<PurchaseRequest> products);
}
