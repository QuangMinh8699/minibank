package org.minh.common.service;

import org.minh.common.schema.request.GetBankAccountByCifRequestBody;
import org.minh.common.schema.response.GetBankAccountByCifResponseBody;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountService {
    GetBankAccountByCifResponseBody getBankAccountByCif(GetBankAccountByCifRequestBody requestBody) throws Exception;
}
