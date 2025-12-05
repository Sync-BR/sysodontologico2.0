package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.handle.exception.DifferentPasswordException;
import com.github.sync.odontolocico.handle.exception.ExistingDateEmailException;
import com.github.sync.odontolocico.handle.exception.ExistingDateCpfException;
import com.github.sync.odontolocico.interfaces.ValidateImp;
import com.github.sync.odontolocico.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class RegisterValidate implements ValidateImp<ClientDto> {

    private final ClientRepository repository;

    public RegisterValidate(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ClientDto object) {
        if (validateEmail(object.getEmail()) != null) throw new ExistingDateEmailException("Email existente");
        if (validateCpf(object.getCpf()) != null) throw new ExistingDateCpfException("CPF existente");
        validatePassword(object.getSecurity().getPassword(), object.getSecurity().getRepeatPassword());
    }

    private void validatePassword(String password, String repeatPassword) {
        if(!password.equals(repeatPassword)) throw new DifferentPasswordException("Senha diferente");
    }

    private ClientEntity validateCpf(String cpf) {
        return repository.findByCpfClient(cpf);
    }

    private ClientEntity validateEmail(String email) {
        return repository.findByEmailClient(email);
    }


}
