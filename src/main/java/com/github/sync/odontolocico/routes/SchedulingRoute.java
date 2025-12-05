package com.github.sync.odontolocico.routes;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.dto.SchedulingDto;
import com.github.sync.odontolocico.service.DentistService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SchedulingRoute {
    private final DentistService serviceDentist;

    public SchedulingRoute(DentistService serviceDentist) {
        this.serviceDentist = serviceDentist;
    }

    @GetMapping("/clinic/scheduling")
    public String addScheduling(Model model, HttpServletRequest request) {
        model.addAttribute("scheduling", new SchedulingDto());
        model.addAttribute("list", serviceDentist.searchList(request));

        return "client/scheduling/register";
    }

}
