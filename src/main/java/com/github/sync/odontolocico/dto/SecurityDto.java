package com.github.sync.odontolocico.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SecurityDto {
    private long id;
    private boolean active;
    private String password;
    private String repeatPassword;

    public SecurityDto() {
    }

    public SecurityDto(boolean active, String password, String repeatPassword) {
        this.active = active;
        this.password = password;
        this.repeatPassword = repeatPassword;

    }



}
