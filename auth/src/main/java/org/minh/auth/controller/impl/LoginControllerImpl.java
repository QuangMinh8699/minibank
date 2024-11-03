package org.minh.auth.controller.impl;

import org.minh.auth.controller.LoginController;
import org.minh.auth.schema.request.LoginRequestBody;
import org.minh.auth.schema.response.LoginResponseBody;
import org.minh.auth.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public LoginResponseBody login(LoginRequestBody requestBody) {
        return null;
    }
}
