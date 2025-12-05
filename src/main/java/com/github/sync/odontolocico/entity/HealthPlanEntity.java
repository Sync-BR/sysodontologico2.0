package com.github.sync.odontolocico.entity;

import com.github.sync.odontolocico.enumeration.HealthInsurance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "HEALTH_PLAN")
public class HealthPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlan;
    private HealthInsurance planHealthInsurance;
    private String numberPlan;
    private LocalDate expirationDatePlan;
}
