package com.Ecommerce.Product.Model.Response;

import java.util.Map;

public record ErrorResponse(Map<String,String> errors) {

}
