package org.minh.common.listener.impl;

import org.minh.common.listener.BankAccountListener;
import org.minh.common.schema.request.GetBankAccountByCifRequestBody;
import org.minh.common.schema.response.GetBankAccountByCifResponseBody;
import org.minh.common.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountListenerImpl implements BankAccountListener {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountListenerImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public GetBankAccountByCifResponseBody getBankAccountByCif(GetBankAccountByCifRequestBody requestBody) throws Exception {
        return bankAccountService.getBankAccountByCif(requestBody);
    }

}
