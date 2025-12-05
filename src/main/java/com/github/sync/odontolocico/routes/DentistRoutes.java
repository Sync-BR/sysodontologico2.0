package com.github.sync.odontolocico.routes;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.service.DentistService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DentistRoutes {
    private final DentistService service;

    public DentistRoutes(DentistService service) {
        this.service = service;
    }

    @GetMapping("/clinic/dentist/register")
    public String register(Model model, HttpServletRequest request) {
        model.addAttribute("dentist", new DentistDto());
        return "client/dentist/register";
    }

    @GetMapping("/clinic/dentist/manage")
    public String manage(Model model, HttpServletRequest request) {
        model.addAttribute("dentist", new DentistDto());
        model.addAttribute("listDentist", service.searchList(request));
        return "client/dentist/manage";

    }

}
