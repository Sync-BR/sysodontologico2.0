package com.github.sync.odontolocico.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Getter
@Setter
@ToString
public class SchedulingDto {
    private long id;
    private DentistDto dentist;
    private PatientsDto patient;
    private ClinicDto clinic;
    private LocalDate scheduledDate;
    private LocalTime scheduledTime;



    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(hora.format(formatter));
    }
}
