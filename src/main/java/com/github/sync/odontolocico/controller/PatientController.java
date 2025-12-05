package com.github.sync.odontolocico.controller;

import com.github.sync.odontolocico.dto.PatientsDto;
import com.github.sync.odontolocico.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/clinic/patient/add")
    public String register(@ModelAttribute("patient") PatientsDto object, HttpServletRequest request) {
        service.preparedRegister(object, request);
        return "redirect:/clinic/patient/add?success";
    }

    @PostMapping("/api/v1/clinic/patient/edit")
    public String update(@ModelAttribute("patient") PatientsDto object, HttpServletRequest request) {
        try {
            service.preparedUpdate(object, request);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "redirect:/clinic/patient/manage?success";

    }
}
