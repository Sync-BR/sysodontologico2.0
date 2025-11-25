package com.github.sync.odontolocico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "SPECIALTY_CLINIC")
public class SpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specialtyId;
    private String specialtyTitle;
    private String specialtyDescription;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinicId")
    private ClinicEntity clinic;
}
