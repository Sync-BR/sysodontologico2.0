package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.AddressDto;
import com.github.sync.odontolocico.dto.TokenDto;
import com.github.sync.odontolocico.entity.AddressEntity;
import com.github.sync.odontolocico.entity.TokenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {
                ClientMapper.class
        })
public interface TokenMapper {
    @Mapping(source = "token", target = "valueToken")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "client", target = "client")
    TokenEntity toEntity(TokenDto object);

    @Mapping(source = "valueToken", target = "token")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "client", target = "client")
    TokenDto toDto(TokenEntity object);
}
