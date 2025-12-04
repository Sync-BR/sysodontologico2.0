package com.github.sync.odontolocico.builder;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class SuccessBuilder {
    public void success(Model model) {
        model.addAttribute("code", "200");
        model.addAttribute("title", "Tudo certo!");
        model.addAttribute("description", "Deu tudo certo com sua operação!");

    }
}
