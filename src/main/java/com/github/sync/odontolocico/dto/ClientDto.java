package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.Permission;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ClientDto {
    private String id;
    private String name;
    private String cpf;
    private String email;
    private Permission permission;
    private SecurityDto security;
    private ClinicDto clinic;
    private LocalDate creationDate;
    private LocalTime creationTime;



}
