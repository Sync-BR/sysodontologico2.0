package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.ClinicDto;
import com.github.sync.odontolocico.entity.ClinicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        SpecialtyMapper.class,
})

public interface ClinicMapper {
    // DTO → Entity
    @Mapping(source = "id", target = "clinicId")
    @Mapping(source = "plan", target = "clinicPlan")
    @Mapping(source = "name", target = "clinicName")
    @Mapping(source = "description", target = "clinicDescription")
    ClinicEntity toEntity(ClinicDto dto);

    // Entity → DTO
    @Mapping(source = "clinicId", target = "id")
    @Mapping(source = "clinicPlan", target = "plan")
    @Mapping(source = "clinicName", target = "name")
    @Mapping(source = "clinicDescription", target = "description")
    ClinicDto toDto(ClinicEntity entity);
}
