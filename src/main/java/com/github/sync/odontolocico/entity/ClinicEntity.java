package com.github.sync.odontolocico.entity;

import com.github.sync.odontolocico.enumeration.Plan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "CLINIC")
public class ClinicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clinicId;
    @Enumerated(EnumType.STRING)
    private Plan clinicPlan;
    private String clinicName;
    private String clinicDescription;




}
