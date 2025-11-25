package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.SpecialtyDto;
import com.github.sync.odontolocico.entity.SpecialtyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClinicMapper.class})

public interface SpecialtyMapper {
    @Mapping(source = "id", target = "specialtyId")
    @Mapping(source = "title", target = "specialtyTitle")
    @Mapping(source = "description", target = "specialtyDescription")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "clinic", target = "clinic")
    SpecialtyEntity toEntity(SpecialtyDto dto);


    @Mapping(source = "specialtyId", target = "id")
    @Mapping(source = "specialtyTitle", target = "title")
    @Mapping(source = "specialtyDescription", target = "description")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "clinic", target = "clinic")
    SpecialtyDto toDto(SpecialtyEntity entity);
}
