package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.PatientsDto;
import com.github.sync.odontolocico.entity.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        AddressMapper.class,
        MedicalHistoryMapper.class,
        HealthPlanMapper.class,
        ClinicMapper.class,
})
public interface PatientsMapper {
    @Mapping(source = "id", target = "idPatient")
    @Mapping(source = "name", target = "namePatient")
    @Mapping(source = "cpf", target = "cpfPatient")
    @Mapping(source = "rg", target = "rgPatient")
    @Mapping(source = "birthDate", target = "birthDatePatient")
    @Mapping(source = "gender", target = "patientGender")
    @Mapping(source = "plan", target = "healthPlanPatient")
    @Mapping(source = "email", target = "emailPatient")
    @Mapping(source = "phone", target = "phoneNumberPatient")
    @Mapping(source = "cellPhone", target = "cellNumberPatient")
    @Mapping(source = "address", target = "addressPatient")
    @Mapping(source = "medicalHistory", target = "medicalHistoryPatient")
    @Mapping(source = "clinic", target = "clinicRegisterPatient")
    @Mapping(source = "registrationDate", target = "registrationDatePatient")
    @Mapping(source = "active", target = "active")
    PatientEntity toEntity(PatientsDto dto);

    @Mapping(source = "idPatient", target = "id")
    @Mapping(source = "namePatient", target = "name")
    @Mapping(source = "cpfPatient", target = "cpf")
    @Mapping(source = "rgPatient", target = "rg")
    @Mapping(source = "birthDatePatient", target = "birthDate")
    @Mapping(source = "patientGender", target = "gender")
    @Mapping(source = "healthPlanPatient", target = "plan")
    @Mapping(source = "emailPatient", target = "email")
    @Mapping(source = "phoneNumberPatient", target = "phone")
    @Mapping(source = "cellNumberPatient", target = "cellPhone")
    @Mapping(source = "addressPatient", target = "address")
    @Mapping(source = "medicalHistoryPatient", target = "medicalHistory")
    @Mapping(source = "clinicRegisterPatient", target = "clinic")
    @Mapping(source = "registrationDatePatient", target = "registrationDate")
    @Mapping(source = "active", target = "active")
    PatientsDto toDto(PatientEntity entity);
}
