package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.enumeration.Plan;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ClinicDto {
    private long id;
    private Plan plan;
    private String name;
    private String description;
}
