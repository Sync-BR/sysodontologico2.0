package com.github.sync.odontolocico.entity;

import com.github.sync.odontolocico.enumeration.Gender;
import com.github.sync.odontolocico.enumeration.HealthInsurance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PATIENTS")
@ToString
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPatient;
    private String namePatient;
    private String cpfPatient;
    private String rgPatient;
    private LocalDate birthDatePatient;
    @Enumerated(EnumType.STRING)
    private Gender patientGender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "healthPlan_Id", referencedColumnName = "idPlan")
    private HealthPlanEntity healthPlanPatient;
    private String emailPatient;
    private String phoneNumberPatient;
    private String cellNumberPatient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "idAddress")
    private AddressEntity addressPatient;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "medicalHistory_Id", referencedColumnName = "idMedical", nullable = true)
    private MedicalHistoryEntity medicalHistoryPatient;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "clinicId")
    private ClinicEntity clinicRegisterPatient;
    private LocalDate registrationDatePatient;
    private boolean isActive;

}
