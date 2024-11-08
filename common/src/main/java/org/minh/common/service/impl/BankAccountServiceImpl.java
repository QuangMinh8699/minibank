package org.minh.common.service.impl;

import org.apache.commons.lang.StringUtils;
import org.minh.common.entity.BankAccountEntity;
import org.minh.common.exception.CommonException;
import org.minh.common.repository.BankAccountRepository;
import org.minh.common.schema.request.GetBankAccountByCifRequestBody;
import org.minh.common.schema.response.BankAccount;
import org.minh.common.schema.response.GetBankAccountByCifResponseBody;
import org.minh.common.service.BankAccountService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    private final ModelMapper modelMapper = new ModelMapper();
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public GetBankAccountByCifResponseBody getBankAccountByCif(GetBankAccountByCifRequestBody requestBody) throws Exception {
        try {
            LOGGER.warn("getBankAccountByCif with request: {}", requestBody);

            if (ObjectUtils.isEmpty(requestBody)) {
                LOGGER.error("requestBody is empty");
                throw new CommonException();
            }

            if (StringUtils.isEmpty(requestBody.getCif())) {
                LOGGER.error("cif is empty");
                throw new CommonException();
            }

            List<BankAccountEntity> bankAccountEntityList = bankAccountRepository.findAllByCif(requestBody.getCif());
            List<BankAccount> bankAccountList = new ArrayList<>();
            for (BankAccountEntity bankAccountEntity : bankAccountEntityList) {
                BankAccount bankAccount;
                bankAccount = modelMapper.map(bankAccountEntity, BankAccount.class);
                bankAccountList.add(bankAccount);
            }

            LOGGER.warn("getBankAccountByCif with response: {}", bankAccountList);
            return new GetBankAccountByCifResponseBody(bankAccountList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new Exception();
        }
    }
}
