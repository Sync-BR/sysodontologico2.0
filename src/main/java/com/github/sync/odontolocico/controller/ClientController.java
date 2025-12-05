package com.github.sync.odontolocico.controller;

import com.github.sync.odontolocico.builder.ErrorsBuilder;
import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.handle.*;
import com.github.sync.odontolocico.service.AuthenticateService;
import com.github.sync.odontolocico.service.ClientService;
import com.github.sync.odontolocico.service.TokenService;
import com.github.sync.odontolocico.util.CookieUtil;
import com.github.sync.odontolocico.validate.ClientValidate;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
    private final AuthenticateService serviceAuth;
    private final TokenService tokenService;
    private final ClientService service;
    private final ClientValidate validateToken;
    private final CookieUtil cookies;

    public ClientController(AuthenticateService serviceAuth, ClientService service, ClientValidate validateToken, TokenService tokenService, CookieUtil cookies) {
        this.serviceAuth = serviceAuth;
        this.service = service;
        this.validateToken = validateToken;
        this.tokenService = tokenService;
        this.cookies = cookies;
    }

    @PostMapping("/api/v1/client/login")
    public String authenticate(@ModelAttribute("login") ClientDto memory, Model model, HttpServletResponse response) {
        Cookie cookie = cookies.configureCookie("authToken", serviceAuth.authenticate(memory));
        response.addCookie(cookie);
        return "redirect:/dashboard";
    }

    @PostMapping("/api/v1/client/register")
    public String register(@ModelAttribute("user") ClientDto memory, Model model, HttpServletResponse response) {
        service.preparedCreatAccount(memory);
        tokenService.registerTokenClinic(validateToken.validateRegister(memory));
        return "redirect:/login?success";
    }

}
