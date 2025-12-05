package com.github.sync.odontolocico.repository;

import com.github.sync.odontolocico.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByCpfPatientAndClinicRegisterPatient_ClinicId(String cpfPatient, long clinicRegisterPatientClinicId);
    List<PatientEntity> findAllByClinicRegisterPatient_ClinicId(long clinicRegisterPatientClinicId);
    Long countAllByClinicRegisterPatient_ClinicId(long clinicRegisterPatientClinicId);

}
