package org.minh.customer.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.minh.customer.schema.response.GetCustomerResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public interface CustomerController {
    GetCustomerResponseBody getCustomer(HttpServletRequest request);
}
