package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.entity.SecurityEntity;
import com.github.sync.odontolocico.handle.exception.PasswordHandleException;
import com.github.sync.odontolocico.interfaces.ValidateImp;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidate implements ValidateImp<SecurityEntity> {

    @Override
    public void validate(SecurityEntity object) {

    }

    public void validatePassword(ClientEntity dateClient, String password) {
        if (!dateClient.getSecurityClient().getPasswordSecurity().equals(password)) {
            throw new PasswordHandleException("Senha incorreta");
        }
    }

}
