package org.minh.common.listener;

import org.minh.common.schema.request.GetBankAccountByCifRequestBody;
import org.minh.common.schema.response.GetBankAccountByCifResponseBody;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountListener {
    @JmsListener(destination = "org.minh.common.getBankAccountByCif")
    GetBankAccountByCifResponseBody getBankAccountByCif(GetBankAccountByCifRequestBody requestBody) throws Exception;
}
