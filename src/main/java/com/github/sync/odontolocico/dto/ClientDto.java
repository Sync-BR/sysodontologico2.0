package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.Gender;
import com.github.sync.odontolocico.enumeration.Permission;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ClientDto {
    private long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private AddressDto  address;
    @Enumerated(EnumType.STRING)
    private Permission permission;
    private SecurityDto security;
    private ClinicDto clinic;
    private LocalDate creationDate;
    private LocalTime creationTime;

    public ClientDto() {
    }
}
