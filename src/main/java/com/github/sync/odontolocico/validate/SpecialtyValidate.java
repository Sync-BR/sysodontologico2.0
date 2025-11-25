package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.handle.exception.ClinicExistingException;
import com.github.sync.odontolocico.handle.exception.SpecialtyExisting;
import com.github.sync.odontolocico.interfaces.ValidateImp;
import com.github.sync.odontolocico.repository.SpecialtyRepository;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyValidate implements ValidateImp<String> {
    private final SpecialtyRepository repository;

    public SpecialtyValidate(SpecialtyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(String object) {
        if(repository.findBySpecialtyTitle(object) != null)
            throw new SpecialtyExisting("Esse especialista já existente");
    }

}
