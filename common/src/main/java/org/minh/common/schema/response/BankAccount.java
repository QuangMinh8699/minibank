package org.minh.common.schema.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String cif;
    private String accountNumber;
    private String totalAmount;
    private String status;
    private String accountClass;
}
