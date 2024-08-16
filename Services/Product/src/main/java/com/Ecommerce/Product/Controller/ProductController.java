package com.Ecommerce.Product.Controller;

import com.Ecommerce.Product.Model.Request.ProductPurchaseRequest;
import com.Ecommerce.Product.Model.Request.ProductRequest;
import com.Ecommerce.Product.Model.Response.ProductPurchaseResponse;
import com.Ecommerce.Product.Model.Response.ProductResponse;
import com.Ecommerce.Product.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/customer")
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> addProduct(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productService.addProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchase(@RequestBody List<ProductPurchaseRequest> productPurchaseRequestList){
        return ResponseEntity.ok(productService.purchase(productPurchaseRequestList));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findByProductId(@PathVariable("product-id") Integer productId){
        return ResponseEntity.ok(productService.findByProductId(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllPoduct() {
        return ResponseEntity.ok(productService.findAllProduct());
    }


}
