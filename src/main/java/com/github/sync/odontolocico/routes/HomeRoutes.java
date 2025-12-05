package com.github.sync.odontolocico.routes;

import com.github.sync.odontolocico.builder.ErrorsBuilder;
import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.dto.ClinicDto;
import com.github.sync.odontolocico.handle.exception.CookieNotFountException;
import com.github.sync.odontolocico.handle.exception.InvalidTokenException;
import com.github.sync.odontolocico.service.TokenService;
import com.github.sync.odontolocico.util.CookieUtil;
import com.github.sync.odontolocico.validate.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeRoutes {
    private final LoginValidate validatorLogin;
    private final TokenValidate tokenValidate;
    private final ClinicValidate clinicValidate;
    private final CookieValidate validate;
    private final ErrorsBuilder builderError;
    private final CookieUtil util;
    private final ClientValidate validateClient;
    private final TokenService service;

    public HomeRoutes(LoginValidate validatorLogin, TokenValidate tokenValidate, ClinicValidate clinicValidate, CookieValidate validate, ErrorsBuilder builderError, CookieUtil util, ClientValidate validateClient, TokenService service) {
        this.validatorLogin = validatorLogin;
        this.tokenValidate = tokenValidate;
        this.clinicValidate = clinicValidate;
        this.validate = validate;
        this.builderError = builderError;
        this.util = util;
        this.validateClient = validateClient;
        this.service = service;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new ClientDto());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new ClientDto());
        return "register";
    }

    @GetMapping("/register/clinic")
    public String registerClinic(@RequestParam("token") String value, Model model, HttpServletRequest request) {
        validatorLogin.validate(request);
        clinicValidate.validate(validatorLogin.validate(request).getEmail());
        service.disableToken(value);
        tokenValidate.validate(value, validatorLogin.validateExistingToken(request));
        model.addAttribute("clinic", new ClinicDto());
        return "clinic";
    }

}
