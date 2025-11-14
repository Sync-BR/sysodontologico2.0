package com.github.sync.odontolocico.entity;

import com.github.sync.odontolocico.enumeration.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity(name = "CLIENT_CLINIC")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    private String nameClient;
    private String cpfClient;
    private String emailClient;
    @Enumerated(EnumType.STRING)
    private Permission permissionClient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "security", referencedColumnName = "idSecurity")
    private SecurityEntity securityClient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinic" , referencedColumnName = "clinicId")
    private ClinicEntity clinicClient;
    private LocalDate createdDate;
    private LocalTime createdTime;

}
