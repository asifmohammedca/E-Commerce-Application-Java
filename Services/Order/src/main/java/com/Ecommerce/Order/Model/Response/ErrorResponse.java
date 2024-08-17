package com.Ecommerce.Order.Model.Response;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
