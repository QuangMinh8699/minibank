package org.minh.auth.schema.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseBody {
    private String accessToken;
    private String tokenType;
    private String expiresIn;
    private String refreshToken;
    private String refreshExpiresIn;
}
