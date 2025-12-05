package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.Gender;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PatientsDto {
    private long id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthDate;
    private Gender gender;
    private HealthPlanDto plan;
    private String email;
    private String phone;
    private String cellPhone;
    private AddressDto address;
    private MedicalHistoryDto medicalHistory;
    private ClinicDto clinic;
    private LocalDate registrationDate;
    private boolean active;


}
