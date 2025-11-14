package com.github.sync.odontolocico.dto;

import com.github.sync.odontolocico.handle.ExistingContent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityDto {
    private long id;
    private boolean active;
    private String password;
    private String repeatPassword;

    public SecurityDto(boolean active, String password, String repeatPassword) {
        this.active = active;
        this.password = password;
        this.repeatPassword = repeatPassword;
        if(password.equals(repeatPassword)){
            throw new ExistingContent("Passwords do not match");
        }
    }



}
