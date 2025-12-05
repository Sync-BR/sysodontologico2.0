package com.github.sync.odontolocico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "DENTIST_PROFESSIONAL_INFO")
public class DentistProfessionalInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dentistId;
    @Column(nullable = false, unique = true)
    private String dentistCro;
    @Column(nullable = false, length = 2)
    private String dentistCroState;
    @Column(nullable = false)
    private LocalDate dentistAdmissionDate;
    @Column(nullable = false)
    private Boolean active;

    public DentistProfessionalInfoEntity() {
    }

    public DentistProfessionalInfoEntity(long dentistId, String dentistCro, String dentistCroState, LocalDate dentistAdmissionDate, Boolean active) {
        this.dentistId = dentistId;
        this.dentistCro = dentistCro;
        this.dentistCroState = dentistCroState;
        this.dentistAdmissionDate = dentistAdmissionDate;
        this.active = active;
    }
}
