package com.github.sync.odontolocico.interfaces;

public abstract class Validator<object>{


    public void validatePatientByCpf(object cpf, Long clinicId){
    }

    public void validateDentistByCpf(object cpf, Long clinicId){
    }
    public void validateDentistByEmail(object email, Long clinicId){
    }

}
