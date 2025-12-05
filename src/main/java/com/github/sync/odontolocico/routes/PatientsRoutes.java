package com.github.sync.odontolocico.routes;

import com.github.sync.odontolocico.dto.AddressDto;
import com.github.sync.odontolocico.dto.PatientsDto;
import com.github.sync.odontolocico.service.PatientService;
import com.github.sync.odontolocico.validate.LoginValidate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientsRoutes {
    private final LoginValidate validator;
    private final PatientService service;

    public PatientsRoutes(LoginValidate validator, PatientService service) {
        this.validator = validator;
        this.service = service;
    }

    @GetMapping("/clinic/patient/add")
    public String addPatient(Model model, HttpServletRequest request) {
        validator.validate(request);
        model.addAttribute("patient", new PatientsDto());
        return "client/patient/addPatient";
    }

    @GetMapping("/clinic/patient/manage")
    public String managePatient(Model model, HttpServletRequest request) {
        validator.validate(request);
        model.addAttribute("listPatient", service.searchList(request));
        model.addAttribute("patient", new PatientsDto());
        return "client/patient/manage";

    }
}
