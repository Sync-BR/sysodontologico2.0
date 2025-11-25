package com.github.sync.odontolocico.controller;

import com.github.sync.odontolocico.dto.SpecialtyDto;
import com.github.sync.odontolocico.service.SpecialtyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class SpecialistController {
    private final SpecialtyService specialtyService;

    public SpecialistController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @PostMapping("/api/v1/clinic/specialty/add")
    public String registerNewSpecialty(@ModelAttribute("newSpecialty") SpecialtyDto memory, HttpServletRequest request) {
        specialtyService.preparedSpecialty(memory, request);
        return "redirect:/clinica/especialista?success";
    }
    @PostMapping("/api/v1/clinic/specialty/edit")

    public String updateSpecialty(@ModelAttribute("newSpecialty") SpecialtyDto memory, HttpServletRequest request) {
        System.out.println(memory);
        specialtyService.update(memory, request);
        return "redirect:/clinica/especialista?successUpdate";

    }


}
