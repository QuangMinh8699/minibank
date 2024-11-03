package org.minh.customer.listener.impl;

import org.minh.customer.listener.CustomerListener;
import org.minh.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerListenerImpl implements CustomerListener {

    private final CustomerService customerService;

    @Autowired
    public CustomerListenerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }
}
