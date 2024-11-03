package org.minh.auth.controller;

import org.minh.auth.schema.request.LoginRequestBody;
import org.minh.auth.schema.response.LoginResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public interface LoginController {
    LoginResponseBody login(LoginRequestBody requestBody);
}
