package com.github.sync.odontolocico.entity;


import com.github.sync.odontolocico.enumeration.Gender;
import com.github.sync.odontolocico.enumeration.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@Entity(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private int ageUser;
    private String nomeUser;
    private String emailUser;
    private String cpfUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "security", referencedColumnName = "idSecurity")
    private SecurityEntity securityUser;
    @Enumerated(EnumType.STRING)
    private Permission permissionUser;
    @Enumerated(EnumType.STRING)
    private Gender genderUser;
    private LocalDate dateOfBirthUser;
    private LocalDate creationDateUser;
    private LocalTime creationTimeUser;

}
