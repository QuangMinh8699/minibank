package org.minh.common.controller;

import org.minh.common.schema.request.GetBankAccountByCifRequestBody;
import org.minh.common.schema.response.GetBankAccountByCifResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bank-account")
public interface BankAccountController {
    GetBankAccountByCifResponseBody getBankAccountByCif(GetBankAccountByCifRequestBody requestBody) throws Exception;
}
