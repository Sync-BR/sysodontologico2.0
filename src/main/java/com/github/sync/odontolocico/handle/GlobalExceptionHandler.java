package com.github.sync.odontolocico.handle;

import com.github.sync.odontolocico.builder.ErrorsBuilder;
import com.github.sync.odontolocico.handle.exception.*;
import com.github.sync.odontolocico.validate.CookieValidate;
import com.github.sync.odontolocico.validate.TokenValidate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final ErrorsBuilder errors;
    private final TokenValidate validateToken;
    private final CookieValidate validateCookie;
    public GlobalExceptionHandler(ErrorsBuilder errors, TokenValidate validateToken, CookieValidate validateCookie) {
        this.errors = errors;
        this.validateToken = validateToken;
        this.validateCookie = validateCookie;
    }
    // Exception de cookie e token
    @ExceptionHandler(CookieNotFountException.class)
    public String cookieError(Model model) {
        errors.errorTokenCookie(model);
        return "error";
    }
    @ExceptionHandler(InvalidTokenException.class)
    public String tokenError(Model model) {
        errors.errorTokenClinic(model);
        return "error";
    }
    // Exception de clinic

    @ExceptionHandler(PasswordHandleException.class)
    public String passwordIncorrectError(Model model) {
        return "redirect:/login?failUser";
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public String clientError(Model model, HttpServletResponse response) {
        errors.errorTokenAuth(model);
        return "error";
    }

    //Exception de login
    @ExceptionHandler(LoginClientNotFoundException.class)
    public String loginClientNotFoundError() {
        return "redirect:/login?failUser";
    }


    //Exception de registro
    @ExceptionHandler(DifferentPasswordException.class)
    public String differentPassword(Model model) {
        return "redirect:/register?failPassword";
    }
    @ExceptionHandler(ExistingDateEmailException.class)
    public String existingEmailError(Model model) {
        return "redirect:/register?failEmail";
    }
    @ExceptionHandler(ExistingDateCpfException.class)
    public String existingCpfError(Model model) {
        return "redirect:/register?failCpf";
    }

    //Exception de clinica
    @ExceptionHandler(ClinicNotFoundException.class)
    public String existingClinic(HttpServletRequest request) {
        String tokenAuth = validateCookie.validate("authToken", null, request);
        return "redirect:/register/clinic?token="+validateToken.validateSearchTokenByEmail(tokenAuth).getToken();
    }
    //Exception de paciente
    @ExceptionHandler(ClinicPatientExisting.class)
    public String existingPatient(HttpServletRequest request) {
        return "redirect:/clinic/patient/add?cpfExisting";
    }
    @ExceptionHandler(ClinicNotExist.class)
    public String clinicNotExisting(Model model) {
        errors.errorClinicNotFount(model);
        return "error";

    }
    //Exception de dentista
    @ExceptionHandler(ClinicDentisCpfExisting.class)
    public String dentistCpfExisting() {
        return "redirect:/clinic/dentist/register?cpfExisting";

    }
    @ExceptionHandler(ClinicDentisEmailExisting.class)
    public String dentistEmailExisting() {
        return "redirect:/clinic/dentist/register?emailExisting";

    }


    @ExceptionHandler(MissingDataException.class)
    public String unknownFailDate(Model model) {
        errors.errorFailOperationDate(model);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String unknown(Model model) {
        errors.errorUnknown(model);
        return "error";
    }

}
