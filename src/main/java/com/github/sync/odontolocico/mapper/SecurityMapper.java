package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.ClinicDto;
import com.github.sync.odontolocico.dto.SecurityDto;
import com.github.sync.odontolocico.entity.ClinicEntity;
import com.github.sync.odontolocico.entity.SecurityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface SecurityMapper {
    // DTO → Entity
    @Mapping(source = "id", target = "idSecurity")
    @Mapping(source = "active", target = "activeSecurity")
    @Mapping(source = "password", target = "passwordSecurity")
    SecurityEntity toEntity(SecurityDto dto);

    // Entity → DTO
    @Mapping(source = "idSecurity", target = "id")
    @Mapping(source = "activeSecurity", target = "active")
    @Mapping(source = "passwordSecurity", target = "password")
    @Mapping(target = "repeatPassword", ignore = true)
    SecurityDto toDto(SecurityEntity entity);
}
