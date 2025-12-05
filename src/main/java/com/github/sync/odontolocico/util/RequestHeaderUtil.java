package com.github.sync.odontolocico.util;

import com.github.sync.odontolocico.handle.exception.InvalidTokenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestHeaderUtil {

    public String getTokenHeader(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    public void checkHeaderBearer(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new InvalidTokenException("Token ausente ou inválido!");
        }
    }

}
