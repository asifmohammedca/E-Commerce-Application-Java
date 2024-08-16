package com.Ecommerce.Product.Service;

import com.Ecommerce.Product.Component.ProductMapper;
import com.Ecommerce.Product.Exception.PurchaseException;
import com.Ecommerce.Product.Model.Request.ProductPurchaseRequest;
import com.Ecommerce.Product.Model.Request.ProductRequest;
import com.Ecommerce.Product.Model.Response.ProductPurchaseResponse;
import com.Ecommerce.Product.Model.Response.ProductResponse;
import com.Ecommerce.Product.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer addProduct(ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

    @Transactional(rollbackFor = PurchaseException.class)
    public List<ProductPurchaseResponse> purchase(List<ProductPurchaseRequest> productPurchaseRequestList) {
        List<ProductPurchaseResponse> purchasedProducts = new ArrayList<>();
        var ids = productPurchaseRequestList
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var products = productRepository.findAllByIdInOrderById(ids);
        if (ids.size() != products.size()) {
            throw new PurchaseException("Some products not exist");
        }
        var sortedPurchaseRequest = productPurchaseRequestList
                .stream().
                sorted(Comparator.comparing(ProductPurchaseRequest :: productId))
                .toList();
        for (int i = 0; i < products.size(); i++) {
            var product = products.get(i);
            var productRequest = sortedPurchaseRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new PurchaseException("Insufficient quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toproductPurchaseResponse(product, productRequest.quantity()));

        }
        return purchasedProducts;
    }

    public ProductResponse findByProductId(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<ProductResponse> findAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
