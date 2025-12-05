package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.dto.ProfessionalInfoDto;
import com.github.sync.odontolocico.entity.DentistEntity;
import com.github.sync.odontolocico.entity.DentistProfessionalInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessionalInfoMapper {
    @Mapping(source = "id", target = "dentistId")
    @Mapping(source = "cro", target = "dentistCro")
    @Mapping(source = "state", target = "dentistCroState")
    @Mapping(source = "admissionDate", target = "dentistAdmissionDate")
    @Mapping(source = "active", target = "active")
    DentistProfessionalInfoEntity toEntity(ProfessionalInfoDto dto);

    @Mapping(source = "dentistId", target = "id")
    @Mapping(source = "dentistCro", target = "cro")
    @Mapping(source = "dentistCroState", target = "state")
    @Mapping(source = "dentistAdmissionDate", target = "admissionDate")
    @Mapping(source = "active", target = "active")
    ProfessionalInfoDto toDto(DentistProfessionalInfoEntity entity);
}
