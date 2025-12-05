package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.entity.DentistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        SecurityMapper.class,
        ClinicMapper.class,
        ProfessionalInfoMapper.class
})
public interface DentistMapper {
    @Mapping(source = "id", target = "dentistId")
    @Mapping(source = "name", target = "dentistName")
    @Mapping(source = "email", target = "dentistEmail")
    @Mapping(source = "cpf", target = "dentistCpf")
    @Mapping(source = "rg", target = "dentistRg")
    @Mapping(source = "phone", target = "dentistPhone")
    @Mapping(source = "commission", target = "dentistCommission")
    @Mapping(source = "birthDate", target = "dentistBirthDate")
    @Mapping(source = "permission", target = "dentistPermission")
    @Mapping(source = "security", target = "dentistSecurity")
    @Mapping(source = "address", target = "dentistAddress")
    @Mapping(source = "professional", target = "professionalInfo")
    @Mapping(source = "clinic", target = "dentistClinic")
    @Mapping(source = "creationDate", target = "creationDate")
    DentistEntity toEntity(DentistDto dto);

    @Mapping(source = "dentistId", target = "id")
    @Mapping(source = "dentistName", target = "name")
    @Mapping(source = "dentistEmail", target = "email")
    @Mapping(source = "dentistCpf", target = "cpf")
    @Mapping(source = "dentistRg", target = "rg")
    @Mapping(source = "dentistPhone", target = "phone")
    @Mapping(source = "dentistCommission", target = "commission")
    @Mapping(source = "dentistBirthDate", target = "birthDate")
    @Mapping(source = "dentistPermission", target = "permission")
    @Mapping(source = "dentistSecurity", target = "security")
    @Mapping(source = "dentistAddress", target = "address")
    @Mapping(source = "professionalInfo", target = "professional")
    @Mapping(source = "dentistClinic", target = "clinic")
    @Mapping(source = "creationDate", target = "creationDate")
    DentistDto toDto(DentistEntity entity);
}
