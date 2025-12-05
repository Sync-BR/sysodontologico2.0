package com.github.sync.odontolocico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MEDICAL_HISTORY")
public class MedicalHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedical;
    private String allergiesMedical;
    private String comorbiditiesMedical;
    private String medicationsMedical;
    private String observationsMedical;

    public MedicalHistoryEntity() {
    }
}
