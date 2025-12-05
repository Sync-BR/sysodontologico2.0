package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.handle.exception.ClinicExistingException;
import com.github.sync.odontolocico.handle.exception.ClinicNotExist;
import com.github.sync.odontolocico.interfaces.ValidateImp;
import com.github.sync.odontolocico.repository.ClientRepository;
import com.github.sync.odontolocico.repository.ClinicRepository;
import org.springframework.stereotype.Component;

@Component
public class ClinicValidate implements ValidateImp<String> {
 private final ClientRepository repository;

    public ClinicValidate(ClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public void validate(String object) {
        if(repository.findByEmailClient(object).getClinicClient() != null){
            throw new ClinicExistingException("Existe uma clinica cadastrada para esse usuário");
        }
    }

    public void validateExistingClinic(String object) {
        if(repository.findByEmailClient(object).getClinicClient() == null){
            throw new ClinicNotExist("Clinica não encontrada");
        }
    }
}
