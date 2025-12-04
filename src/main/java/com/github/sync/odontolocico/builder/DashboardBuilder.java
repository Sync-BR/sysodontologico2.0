package com.github.sync.odontolocico.builder;

import com.github.sync.odontolocico.service.PatientService;
import com.github.sync.odontolocico.service.SpecialtyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class DashboardBuilder {
    private final SpecialtyService serviceSpecialty;
    private final PatientService servicePatient;

    public DashboardBuilder(SpecialtyService serviceSpecialty, PatientService servicePatient) {
        this.serviceSpecialty = serviceSpecialty;
        this.servicePatient = servicePatient;
    }

    public void searchReportValues(Model model, HttpServletRequest request) {
        model.addAttribute("reportSpecialty", serviceSpecialty.count(request));
        model.addAttribute("reportPatient", servicePatient.count(request));
    }

}
