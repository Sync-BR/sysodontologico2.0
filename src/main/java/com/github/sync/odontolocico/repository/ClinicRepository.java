package com.github.sync.odontolocico.repository;

import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.entity.ClinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<ClinicEntity, Integer> {
}
