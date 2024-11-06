package org.minh.common.service.impl;

import org.minh.common.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountServiceImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
}
