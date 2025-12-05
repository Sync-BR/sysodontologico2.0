package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.dto.SecurityDto;
import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.enumeration.Permission;
import com.github.sync.odontolocico.enumeration.Plan;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.mapper.ClientMapper;
import com.github.sync.odontolocico.repository.ClientRepository;
import com.github.sync.odontolocico.util.CookieUtil;
import com.github.sync.odontolocico.validate.RegisterValidate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ClientService extends ServiceImp<ClientEntity, ClientDto> {

    private final ClientMapper mapper;
    private final ClientRepository repository;
    private final RegisterValidate validateRegister;

    public ClientService(ClientMapper mapper, ClientRepository repository, RegisterValidate validateRegister) {
        this.mapper = mapper;
        this.repository = repository;
        this.validateRegister = validateRegister;
    }

    public void preparedCreatAccount(ClientDto memory) {
        validateRegister.validate(memory);
        memory.setPermission(Permission.CLIENT);
        memory.setSecurity(new SecurityDto(false, memory.getSecurity().getPassword(), memory.getSecurity().getRepeatPassword()));
        memory.setCreationDate(LocalDate.now());
        memory.setCreationTime(LocalTime.now());
        save(mapper.toEntity(memory));
    }

    @Override
    protected void save(ClientEntity entity) {
        repository.save(entity);
    }


}
