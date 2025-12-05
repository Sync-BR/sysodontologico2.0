package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.Permission;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@ToString
public class DentistDto {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String phone;
    private BigDecimal commission;
    private LocalDate birthDate;
    private Permission permission;
    private SecurityDto security;
    private AddressDto address;
    private ProfessionalInfoDto professional;
    private ClinicDto clinic;
    private LocalDate creationDate;

}
