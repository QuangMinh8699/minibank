package org.minh.common.schema.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetBankAccountByCifResponseBody {
    private List<BankAccount> bankAccounts;
}
