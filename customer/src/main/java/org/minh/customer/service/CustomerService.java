package org.minh.customer.service;

import jakarta.servlet.http.HttpServletRequest;
import org.minh.customer.schema.request.GetCustomerByUsernameRequestBody;
import org.minh.customer.schema.response.GetCustomerResponseBody;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    GetCustomerResponseBody getCustomer(HttpServletRequest httpServletRequest);

    GetCustomerResponseBody getCustomerByUsername(GetCustomerByUsernameRequestBody requestBody, HttpServletRequest httpServletRequest) throws Exception;
}
