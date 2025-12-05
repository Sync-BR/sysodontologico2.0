package com.github.sync.odontolocico.controller;


import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.dto.ClinicDto;
import com.github.sync.odontolocico.service.ClinicService;
import com.github.sync.odontolocico.validate.ClinicValidate;
import com.github.sync.odontolocico.validate.LoginValidate;
import com.github.sync.odontolocico.validate.TokenValidate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClinicController {
    private final ClinicService service;
    public final LoginValidate validateAuth;
    private final ClinicValidate validateClinic;
    private final TokenValidate tokenValidate;

    public ClinicController(ClinicService service, LoginValidate validateAuth, ClinicValidate validateClinic, TokenValidate tokenValidate) {
        this.service = service;
        this.validateAuth = validateAuth;
        this.validateClinic = validateClinic;
        this.tokenValidate = tokenValidate;
    }

    @PostMapping("/api/v1/clinic/new")
    public String registerNewClinic(@ModelAttribute("clinic") ClinicDto memory, HttpServletRequest request) {
        ClientDto memoryDto = validateAuth.validate(request);
        tokenValidate.validateSearchTokenByEmail(validateAuth.validateExistingToken(request)).getToken();
        validateClinic.validate(memoryDto.getEmail());
        service.preparedClinic(memory, memoryDto.getEmail());
        return "redirect:/dashboard";
    }



}
