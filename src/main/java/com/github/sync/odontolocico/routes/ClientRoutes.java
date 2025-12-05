package com.github.sync.odontolocico.routes;

import com.github.sync.odontolocico.builder.DashboardBuilder;
import com.github.sync.odontolocico.validate.ClientValidate;
import com.github.sync.odontolocico.validate.LoginValidate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientRoutes {
    private final LoginValidate validatorLogin;
    private final ClientValidate validateClient;
    private final DashboardBuilder builderDashboard;
    public ClientRoutes(LoginValidate validatorLogin, ClientValidate validateClient, DashboardBuilder builderDashboard) {
        this.validatorLogin = validatorLogin;
        this.validateClient = validateClient;
        this.builderDashboard = builderDashboard;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpServletRequest request) {
        validateClient.validateExistingClinic(validatorLogin.validate(request));
        builderDashboard.searchReportValues(model, request);
        return "client/dashboard";
    }


}
