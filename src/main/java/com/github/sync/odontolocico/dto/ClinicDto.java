package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.Plan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicDto {
    private long id;
    private Plan plan;
    private String name;
    private String description;
}
