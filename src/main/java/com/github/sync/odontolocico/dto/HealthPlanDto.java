package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.HealthInsurance;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class HealthPlanDto {
    private long id;
    private HealthInsurance plan;
    private String planNumber;
    private LocalDate planExpiration;

}
