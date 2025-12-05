package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.handle.exception.AccountNotFoundException;
import com.github.sync.odontolocico.handle.exception.ClinicExistingException;
import com.github.sync.odontolocico.handle.exception.ClinicNotFoundException;
import com.github.sync.odontolocico.handle.exception.LoginClientNotFoundException;
import com.github.sync.odontolocico.mapper.ClientMapper;
import com.github.sync.odontolocico.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientValidate {
    private final ClientMapper mapper;
    private final PasswordValidate validate;
    private final ClientRepository clientRepository;

    public ClientValidate(ClientMapper mapper, PasswordValidate validate, ClientRepository clientRepository) {
        this.mapper = mapper;
        this.validate = validate;
        this.clientRepository = clientRepository;
    }

    public ClientDto validateExistingEmail(String email) {
        ClientDto memory = mapper.toDto(clientRepository.findByEmailClient(email));
        if(memory == null) {
            throw new LoginClientNotFoundException("Client not found");
        }
        return mapper.toDto(clientRepository.findByEmailClient(email));
    }



    public void validateLogin(ClientDto clientDto) {
        ClientEntity memoryEntity = clientRepository.findByEmailClient(clientDto.getEmail());
        if(memoryEntity == null) {
            throw new LoginClientNotFoundException("Client not found");

        }
        validate.validatePassword(memoryEntity, clientDto.getSecurity().getPassword());
    }
    public ClientDto validateRegister(ClientDto clientDto) {
        ClientEntity memoryEntity = clientRepository.findByEmailClient(clientDto.getEmail());
        if (memoryEntity == null) {
            throw new AccountNotFoundException("Está conta não foi encontrada!");
        }
        validate.validatePassword(memoryEntity, clientDto.getSecurity().getPassword());
        return mapper.toDto(memoryEntity);
    }

    public void validateExistingClinic(ClientDto memory) {
         if (memory.getClinic() == null) {
            throw new ClinicNotFoundException("Clinica não encontrada!");
        }
    }
}
