package com.github.sync.odontolocico.builder;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class ErrorsBuilder {

    public void errorTokenCookie(Model model) {
        model.addAttribute("code", "17FD20");
        model.addAttribute("title", "Token não encontrado");
        model.addAttribute("description", "O token fornecido é inválido ou não pôde ser verificado.");
    }
    public void errorTokenAuth(Model model) {
        model.addAttribute("code", "17FD21");
        model.addAttribute("title", "Token de autorização não encontrado");
        model.addAttribute("description", "O token fornecido é inválido ou não pôde ser verificado.");

    }
    public void errorTokenClinic(Model model) {
        model.addAttribute("code", "17FD22");
        model.addAttribute("title", "Token de autorização não encontrado");
        model.addAttribute("description", "O token fornecido é inválido ou não pôde ser verificado.");

    }
    public void errorUnknown(Model model) {
        model.addAttribute("code", "27ED00");
        model.addAttribute("title", "Erro desconhecido");
        model.addAttribute("description", "Não conseguimnos encontrar sua solicitação");

    }
}
