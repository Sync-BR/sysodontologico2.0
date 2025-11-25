package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.SpecialtyDto;
import com.github.sync.odontolocico.entity.SpecialtyEntity;
import com.github.sync.odontolocico.interfaces.ServiceGetImp;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.mapper.ClinicMapper;
import com.github.sync.odontolocico.mapper.SpecialtyMapper;
import com.github.sync.odontolocico.repository.SpecialtyRepository;
import com.github.sync.odontolocico.validate.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SpecialtyService extends ServiceImp<SpecialtyEntity, SpecialtyDto> implements ServiceGetImp<HttpServletRequest,SpecialtyDto> {
   private final LoginValidate validateAuth;
   private final SpecialtyValidate validateSpecialty;
   private final ClinicValidate validateClinic;
   private final SpecialtyRepository repository;
   private final SpecialtyMapper mapper;
   private final ClinicMapper mapperClinic;

    public SpecialtyService(LoginValidate validateAuth, SpecialtyValidate validateSpecialty, ClinicValidate validateClinic, SpecialtyRepository repository, SpecialtyMapper mapper, ClinicMapper mapperClinic) {
        this.validateAuth = validateAuth;
        this.validateSpecialty = validateSpecialty;
        this.validateClinic = validateClinic;
        this.repository = repository;
        this.mapper = mapper;
        this.mapperClinic = mapperClinic;
    }

    public void preparedSpecialty(SpecialtyDto memory, HttpServletRequest request){
        validateSpecialty.validate(memory.getTitle().toLowerCase());
        validateClinic.validateExistingClinic(validateAuth.validate(request).getEmail());
        memory.setClinic(validateAuth.validate(request).getClinic());
        memory.setTitle(memory.getTitle().toLowerCase());
        memory.setActive(true);
        save(mapper.toEntity(memory));
    }

    public void update(SpecialtyDto memory, HttpServletRequest request){
        memory.setClinic(validateAuth.validate(request).getClinic());
        save(mapper.toEntity(memory));
    }

    @Override
    protected void save(SpecialtyEntity entity) {
        repository.save(entity);
    }



    @Override
    public List<SpecialtyDto> searchList(HttpServletRequest request) {
        List<SpecialtyEntity> list = repository.findAllByClinic_ClinicId(validateAuth.validate(request).getClinic().getId());
        List<SpecialtyDto> dtoList = new ArrayList<>();
        for(SpecialtyEntity entity : list){
            dtoList.add(mapper.toDto(entity));
        }
        return dtoList;
    }
}
