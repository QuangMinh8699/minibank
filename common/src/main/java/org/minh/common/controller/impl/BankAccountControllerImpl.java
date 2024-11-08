package org.minh.common.controller.impl;

import jakarta.servlet.http.HttpServletRequest;
import org.minh.common.controller.BankAccountController;
import org.minh.common.schema.request.GetBankAccountByCifRequestBody;
import org.minh.common.schema.response.GetBankAccountByCifResponseBody;
import org.minh.common.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountControllerImpl implements BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountControllerImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public GetBankAccountByCifResponseBody getBankAccountByCif(@RequestBody GetBankAccountByCifRequestBody requestBody, HttpServletRequest httpServletRequest) throws Exception {
        return bankAccountService.getBankAccountByCif(requestBody);
    }
}
