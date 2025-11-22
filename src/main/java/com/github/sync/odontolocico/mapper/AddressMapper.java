package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.AddressDto;
import com.github.sync.odontolocico.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(source = "id", target = "idAddress")
    @Mapping(source = "cep", target = "postalCode")
    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "complemento", target = "complement")
    @Mapping(source = "bairro", target = "district")
    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "uf", target = "state")
    @Mapping(source = "numero", target = "number")
    AddressEntity toEntity(AddressDto dto);


    @Mapping(source = "idAddress", target = "id")
    @Mapping(source = "postalCode", target = "cep")
    @Mapping(source = "street", target = "logradouro")
    @Mapping(source = "complement", target = "complemento")
    @Mapping(source = "district", target = "bairro")
    @Mapping(source = "city", target = "localidade")
    @Mapping(source = "state", target = "uf")
    @Mapping(source = "number", target = "numero")
    AddressDto toDto(AddressEntity entity);
}
