package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.dto.SecurityDto;
import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.enumeration.Permission;
import com.github.sync.odontolocico.enumeration.Plan;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.repository.ClientRepository;
import com.github.sync.odontolocico.validate.RegisterValidate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ClientService extends ServiceImp<ClientEntity, ClientDto> {
    private final ClientRepository repository;
    private final RegisterValidate validateRegister;

    public ClientService(ClientRepository repository, RegisterValidate validate) {
        this.repository = repository;
        this.validateRegister = validate;
    }


    public void preparedCreatAccount(ClientDto memory) {
        validateRegister.validate(memory);
        memory.setPermission(Permission.CLIENT);
        memory.setSecurity(new SecurityDto(true ,memory.getSecurity().getPassword(), memory.getSecurity().getRepeatPassword()));
        memory.setCreationDate(LocalDate.now());
        memory.setCreationTime(LocalTime.now());
        memory.getClinic().setPlan(Plan.FREE);
        save(null);
    }

    @Override
    protected void save(ClientEntity entity) {
        repository.save(entity);
    }


    public static void main(String[] args) {
        LocalDate dateNow =  LocalDate.now();
        LocalDate dateOfBright = LocalDate.parse("1998-04-24");
        int calc1 = dateNow.getYear() - dateOfBright.getYear();
        System.out.println("Calculo: " +calc1);
    }

}
