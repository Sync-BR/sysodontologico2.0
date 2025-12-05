package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.interfaces.ValidateImp;
import com.github.sync.odontolocico.interfaces.ValidateObject;
import com.github.sync.odontolocico.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.Validate;
@Component
public class LoginValidate implements ValidateObject<ClientDto, HttpServletRequest> {
    private final CookieValidate validate;
    private final ClientValidate validateClient;
    private final JwtUtil util;
    public LoginValidate(CookieValidate validate, ClientValidate validateClient, JwtUtil util) {
        this.validate = validate;
        this.validateClient = validateClient;
        this.util = util;
    }



    @Override
    public ClientDto validate(HttpServletRequest object) {
        String authToken = validate.validate("authToken", null, object);
        util.validateToken(authToken);
        return validateClient.validateExistingEmail(util.getUsernameFromToken(authToken));
    }

    public String validateExistingToken(HttpServletRequest object) {
        String authToken = validate.validate("authToken", null, object);
        util.validateToken(authToken);
        return authToken;
    }


}
