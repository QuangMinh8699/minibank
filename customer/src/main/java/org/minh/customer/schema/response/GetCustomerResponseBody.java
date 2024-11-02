package org.minh.customer.schema.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponseBody {
    private String cif;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String username;
}
