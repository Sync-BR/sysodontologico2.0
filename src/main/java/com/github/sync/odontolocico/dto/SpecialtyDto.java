package com.github.sync.odontolocico.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpecialtyDto {
    private long id;
    private String title;
    private String description;
    private boolean active;
    private ClinicDto clinic;

    public SpecialtyDto() {
    }
}
