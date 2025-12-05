package com.github.sync.odontolocico.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ProfessionalInfoDto {
    private long id;
    private String cro;
    private String state;
    private LocalDate admissionDate;
    private Boolean active;
}
