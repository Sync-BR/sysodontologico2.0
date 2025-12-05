package com.github.sync.odontolocico.entity;

import com.github.sync.odontolocico.enumeration.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "DENTIST_CLINIC")
public class DentistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentistId;
    @Enumerated(EnumType.STRING)
    private Permission dentistPermission;
    private String dentistName;
    private String dentistEmail;
    private String dentistCpf;
    private String dentistRg;
    private String dentistPhone;
    private LocalDate dentistBirthDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "security_id", referencedColumnName = "idSecurity")
    private SecurityEntity dentistSecurity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "idAddress")
    private AddressEntity dentistAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id", referencedColumnName = "dentistId")
    private DentistProfessionalInfoEntity professionalInfo;


    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private ClinicEntity dentistClinic;

    private BigDecimal dentistCommission;
    private LocalDate creationDate;
}
