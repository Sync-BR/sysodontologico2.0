package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.MedicalHistoryDto;
import com.github.sync.odontolocico.entity.MedicalHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {
    @Mapping(source = "id", target = "idMedical")
    @Mapping(source = "allergies", target = "allergiesMedical")
    @Mapping(source = "comorbidities", target = "comorbiditiesMedical")
    @Mapping(source = "medications", target = "medicationsMedical")
    @Mapping(source = "observations", target = "observationsMedical")
    MedicalHistoryEntity toEntity(MedicalHistoryDto dto);

    @Mapping(source = "idMedical", target = "id")
    @Mapping(source = "allergiesMedical", target = "allergies")
    @Mapping(source = "comorbiditiesMedical", target = "comorbidities")
    @Mapping(source = "medicationsMedical", target = "medications")
    @Mapping(source = "observationsMedical", target = "observations")
    MedicalHistoryDto toDto(MedicalHistoryEntity entity);
}
