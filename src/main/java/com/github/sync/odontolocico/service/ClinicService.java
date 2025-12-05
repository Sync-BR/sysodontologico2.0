package com.github.sync.odontolocico.service;


import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.dto.ClinicDto;
import com.github.sync.odontolocico.entity.ClinicEntity;
import com.github.sync.odontolocico.enumeration.Plan;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.mapper.ClientMapper;
import com.github.sync.odontolocico.repository.ClinicRepository;
import com.github.sync.odontolocico.validate.ClientValidate;
import org.springframework.stereotype.Service;

@Service
public class ClinicService extends ServiceImp<ClinicEntity, ClinicDto> {
    private final ClientValidate validate;
    private final ClientService serviceClient;
    private final ClinicRepository repository;
    private final ClientMapper mapperClient;

    public ClinicService(ClientValidate validate, ClientService serviceClient, ClinicRepository repository, ClientMapper mapperClient) {
        this.validate = validate;
        this.serviceClient = serviceClient;
        this.repository = repository;
        this.mapperClient = mapperClient;
    }

    public void preparedClinic(ClinicDto memory, String email){
        memory.setPlan(Plan.FREE);
        ClientDto memoryDto = validate.validateExistingEmail(email);
        memoryDto.setClinic(memory);
        serviceClient.save(mapperClient.toEntity(memoryDto));
    }

    public ClinicDto searchClinic(String valueEmail){


        return new ClinicDto();
    }

    @Override
    protected void save(ClinicEntity entity) {
        repository.save(entity);

    }
}
