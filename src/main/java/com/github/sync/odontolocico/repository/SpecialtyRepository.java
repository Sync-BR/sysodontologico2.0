package com.github.sync.odontolocico.repository;

import com.github.sync.odontolocico.entity.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, Long> {
    SpecialtyEntity findBySpecialtyTitle(String specialtyTitle);
    List<SpecialtyEntity> findAllByClinic_ClinicId(Long clinicId);
    Long countAllByClinic_ClinicId(Long clinicId);
}
