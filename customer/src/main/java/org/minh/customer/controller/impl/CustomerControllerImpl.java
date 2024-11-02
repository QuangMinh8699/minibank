package org.minh.customer.controller.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.minh.customer.controller.CustomerController;
import org.minh.customer.schema.response.GetCustomerResponseBody;
import org.minh.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public GetCustomerResponseBody getCustomer(HttpServletRequest httpServletRequest) {
        return customerService.getCustomer(httpServletRequest);
    }

}
