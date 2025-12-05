package com.github.sync.odontolocico.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MedicalHistoryDto {
    private long id;
    private String allergies;
    private String comorbidities;
    private String medications;
    private String observations;
}
