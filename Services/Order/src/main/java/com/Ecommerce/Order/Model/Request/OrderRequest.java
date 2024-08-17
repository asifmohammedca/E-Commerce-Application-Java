package com.Ecommerce.Order.Model.Request;

import com.Ecommerce.Order.Model.Enum.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method should be specify")
        PaymentMethod paymentMethod,

        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotEmpty(message = "At least purchase one product")
        List<PurchaseRequest> products) {
}
