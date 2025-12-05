package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.handle.exception.CookieNotFountException;
import com.github.sync.odontolocico.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class CookieValidate {
    private final CookieUtil util;

    public CookieValidate(CookieUtil util) {
        this.util = util;
    }

    public String validate(String name, String value, HttpServletRequest request) {
       final String searchValue = util.getRequestCookie(name, value, request );
        if(searchValue == null) {
            throw new CookieNotFountException("Coockie não encontrado!");
        }
        return searchValue;
    }


}
