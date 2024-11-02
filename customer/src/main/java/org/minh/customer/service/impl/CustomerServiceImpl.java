package org.minh.customer.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.minh.customer.entity.CustomerEntity;
import org.minh.customer.exception.CustomerException;
import org.minh.customer.repository.CustomerRepository;
import org.minh.customer.schema.request.GetCustomerByUsernameRequestBody;
import org.minh.customer.schema.response.GetCustomerResponseBody;
import org.minh.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public GetCustomerResponseBody getCustomer(HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public GetCustomerResponseBody getCustomerByUsername(GetCustomerByUsernameRequestBody requestBody, HttpServletRequest httpServletRequest) throws Exception {
        try {
            String username = requestBody.getUsername();
            if (StringUtils.isEmpty(username)) {
                LOGGER.error("username is null or empty");
                throw new CustomerException();
            }

            CustomerEntity customer = customerRepository.findByUsername(username);
            if (ObjectUtils.isEmpty(customer)) {
                return null;
            }

            return null;
        } catch (CustomerException e) {
            LOGGER.error("getCustomerByUsername error ", e);
            throw new CustomerException();
        } catch (Exception e) {
            LOGGER.error("getCustomerByUsername error ", e);
            throw new Exception();
        }
    }
}
