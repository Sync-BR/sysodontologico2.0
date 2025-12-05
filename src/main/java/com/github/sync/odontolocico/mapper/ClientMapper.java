package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {
                AddressMapper.class,
                SecurityMapper.class,
                ClinicMapper.class
        }
)
public interface ClientMapper {
    // DTO → Entity
    @Mapping(source = "id", target = "clientId")
    @Mapping(source = "name", target = "nameClient")
    @Mapping(source = "cpf", target = "cpfClient")
    @Mapping(source = "email", target = "emailClient")
    @Mapping(source = "phone", target = "phoneClient")
    @Mapping(source = "gender", target = "genderClient")
    @Mapping(source = "address", target = "addressClient")         // AddressMapper
    @Mapping(source = "permission", target = "permissionClient")
    @Mapping(source = "security", target = "securityClient") // SecurityMapper
    @Mapping(source = "clinic", target = "clinicClient")     // ClinicMapper
    @Mapping(source = "creationDate", target = "createdDate")
    @Mapping(source = "creationTime", target = "createdTime")
    ClientEntity toEntity(ClientDto dto);

    // Entity → DTO
    @Mapping(source = "clientId", target = "id")
    @Mapping(source = "nameClient", target = "name")
    @Mapping(source = "cpfClient", target = "cpf")
    @Mapping(source = "emailClient", target = "email")
    @Mapping(source = "phoneClient", target = "phone")
    @Mapping(source = "genderClient", target = "gender")
    @Mapping(source = "addressClient", target = "address")         // AddressMapper
    @Mapping(source = "permissionClient", target = "permission")
    @Mapping(source = "securityClient", target = "security") // SecurityMapper
    @Mapping(source = "clinicClient", target = "clinic")     // ClinicMapper
    @Mapping(source = "createdDate", target = "creationDate")
    @Mapping(source = "createdTime", target = "creationTime")
    ClientDto toDto(ClientEntity entity);
}
