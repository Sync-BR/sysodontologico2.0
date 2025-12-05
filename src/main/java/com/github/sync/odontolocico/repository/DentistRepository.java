package com.github.sync.odontolocico.repository;

import com.github.sync.odontolocico.entity.DentistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepository extends JpaRepository<DentistEntity, Long> {

    DentistEntity findByDentistCpfAndDentistClinic_ClinicId(String dentistCpf, long dentistClinicClinicId);

    DentistEntity findByDentistEmailAndDentistClinic_ClinicId(String dentistEmail, long dentistClinicClinicId);
    List<DentistEntity> findAllByDentistClinicClinicId(long dentistClinicClinicId);
}
