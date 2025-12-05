package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.entity.ClinicEntity;
import com.github.sync.odontolocico.entity.DentistEntity;
import com.github.sync.odontolocico.entity.DentistProfessionalInfoEntity;
import com.github.sync.odontolocico.enumeration.Permission;
import com.github.sync.odontolocico.handle.exception.MissingDataException;
import com.github.sync.odontolocico.interfaces.ServiceGetImp;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.mapper.DentistMapper;
import com.github.sync.odontolocico.repository.DentistRepository;
import com.github.sync.odontolocico.validate.DentistValidate;
import com.github.sync.odontolocico.validate.LoginValidate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DentistService extends ServiceImp<DentistEntity, DentistDto> implements ServiceGetImp<HttpServletRequest, DentistDto> {
    private final DentistValidate validator;
    private final LoginValidate validatorAuth;
    private final DentistMapper mapper;
    private final DentistRepository repository;

    public DentistService(DentistValidate validator, LoginValidate validatorAuth, DentistMapper mapper, DentistRepository repository) {
        this.validator = validator;
        this.validatorAuth = validatorAuth;
        this.mapper = mapper;
        this.repository = repository;
    }

    public void preparedRegister(DentistDto dto, HttpServletRequest request) {
        validator.validateRegister(dto.getCpf(), dto.getEmail(), validatorAuth.validate(request).getClinic().getId());
        dto.setPermission(Permission.DENTIST);
        dto.setCreationDate(LocalDate.now());
        dto.setClinic(validatorAuth.validate(request).getClinic());
        save(mapper.toEntity(dto));
    }

    public void preparedUpdate(DentistDto dto, HttpServletRequest request) {
        update(mapper.toEntity(dto), request);
    }

    @Override
    protected void save(DentistEntity entity) {
        repository.save(entity);
    }

    private DentistEntity validateDateUpdate(DentistEntity memoryUpdate, DentistEntity searchObject) {
        if (searchObject.getDentistId() == 0 || memoryUpdate.getDentistCpf().isEmpty() || memoryUpdate.getDentistClinic() == null) {
            throw new MissingDataException("Falta dados nessa operação");

        }


        memoryUpdate.getDentistAddress().setIdAddress(searchObject.getDentistAddress().getIdAddress());
        memoryUpdate.setDentistPermission(Permission.DENTIST);


        if (memoryUpdate.getProfessionalInfo() == null) {
            throw new MissingDataException("Falta dados nessa operação");
        }
        //Fazer una verificação do número cross para evitar erro de unique
        memoryUpdate.getProfessionalInfo().setDentistId(searchObject.getProfessionalInfo().getDentistId());


        if (memoryUpdate.getDentistSecurity() == null) {
            memoryUpdate.setDentistSecurity(searchObject.getDentistSecurity());
        }

        return memoryUpdate;
    }

    @Override
    protected void update(DentistEntity entity, HttpServletRequest request) {
        super.update(entity, request);
        DentistEntity searchDate = repository.findByDentistCpfAndDentistClinic_ClinicId(entity.getDentistCpf(), validatorAuth.validate(request).getClinic().getId());
        entity.setDentistClinic(searchDate.getDentistClinic());
        save(validateDateUpdate(entity, searchDate));

    }

    @Override
    public List<DentistDto> searchList(HttpServletRequest object) {
        List<DentistDto> dtoList = new ArrayList<>();
        for (DentistEntity entity : repository.findAllByDentistClinicClinicId(validatorAuth.validate(object).getClinic().getId())) {
            dtoList.add(mapper.toDto(entity));
        }
        return dtoList;
    }

    @Override
    public long count(HttpServletRequest object) {
        return 0;
    }
}
