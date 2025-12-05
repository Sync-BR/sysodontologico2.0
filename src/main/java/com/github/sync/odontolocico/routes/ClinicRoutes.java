package com.github.sync.odontolocico.routes;

import com.github.sync.odontolocico.dto.SpecialtyDto;
import com.github.sync.odontolocico.service.SpecialtyService;
import com.github.sync.odontolocico.validate.LoginValidate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClinicRoutes {
    private final LoginValidate validateAuth;
    private final SpecialtyService specialtyService;

    public ClinicRoutes(LoginValidate validateAuth, SpecialtyService specialtyService) {
        this.validateAuth = validateAuth;
        this.specialtyService = specialtyService;
    }

    @GetMapping("/clinica/especialista")
    public String specialty(Model model , HttpServletRequest request) {
        validateAuth.validateExistingToken(request);
        model.addAttribute("listSpecialty", specialtyService.searchList(request));
        model.addAttribute("newSpecialty", new SpecialtyDto());
        return "client/specialty/index";
    }
}
