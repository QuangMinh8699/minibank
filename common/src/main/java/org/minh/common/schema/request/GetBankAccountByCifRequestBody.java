package org.minh.common.schema.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBankAccountByCifRequestBody {
    private String cif;
}
