package com.Ecommerce.Customer.Model.Response;

import java.util.Map;

public record ErrorResponse(Map<String,String> errors) {

}
