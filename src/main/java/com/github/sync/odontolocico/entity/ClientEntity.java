package com.github.sync.odontolocico.entity;

import com.github.sync.odontolocico.dto.AddressDto;
import com.github.sync.odontolocico.enumeration.Gender;
import com.github.sync.odontolocico.enumeration.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@Entity(name = "CLIENT_CLINIC")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    private String nameClient;
    private String cpfClient;
    private String emailClient;
    private String phoneClient;
    @Enumerated(EnumType.STRING)
    private Gender genderClient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "idAddress")
    private AddressEntity addressClient;
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
