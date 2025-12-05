package com.github.sync.odontolocico.controller;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.service.DentistService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DentistController {
    private final DentistService service;

    public DentistController(DentistService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/clinic/dentist/new")
    public String addDentist(@ModelAttribute("dentist") DentistDto dto, HttpServletRequest request) {
        service.preparedRegister(dto, request);
        return "redirect:/clinic/dentist/register?success";
    }

    @PostMapping("/api/v1/clinic/dentist/edit")
    public String updateDentist(@ModelAttribute("dentist") DentistDto dto, HttpServletRequest request) {
        try {

            service.preparedUpdate(dto, request);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "redirect:/clinic/dentist/manage?success";
    }
}
