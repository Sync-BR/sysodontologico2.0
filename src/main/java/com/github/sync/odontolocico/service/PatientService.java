package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.PatientsDto;
import com.github.sync.odontolocico.dto.SecurityDto;
import com.github.sync.odontolocico.entity.PatientEntity;
import com.github.sync.odontolocico.handle.exception.MissingDataException;
import com.github.sync.odontolocico.interfaces.ServiceGetImp;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.mapper.AddressMapper;
import com.github.sync.odontolocico.mapper.HealthPlanMapper;
import com.github.sync.odontolocico.mapper.PatientsMapper;
import com.github.sync.odontolocico.mapper.ProfessionalInfoMapper;
import com.github.sync.odontolocico.repository.PatientRepository;
import com.github.sync.odontolocico.validate.CookieValidate;
import com.github.sync.odontolocico.validate.LoginValidate;
import com.github.sync.odontolocico.validate.PatientValidate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService extends ServiceImp<PatientEntity, PatientsDto> implements ServiceGetImp<HttpServletRequest, PatientsDto> {

    private final LoginValidate validateLogin;
    private final PatientValidate validate;
    private final PatientRepository repository;
    private final PatientsMapper mapper;
    private final AddressMapper mapperAddress;
    private final HealthPlanMapper mapperHealthPlan;

    public PatientService(LoginValidate validateLogin, PatientValidate validate, PatientRepository repository, PatientsMapper mapper, AddressMapper mapperAddress, ProfessionalInfoMapper mapperProfessionalInfo, HealthPlanMapper mapperHealthPlan) {
        this.validateLogin = validateLogin;
        this.validate = validate;
        this.repository = repository;
        this.mapper = mapper;
        this.mapperAddress = mapperAddress;
        this.mapperHealthPlan = mapperHealthPlan;
    }

    private PatientEntity checkDateNull(PatientsDto object, long clinicId) {
        PatientEntity patient = repository.findByCpfPatientAndClinicRegisterPatient_ClinicId(object.getCpf(), clinicId);

        if (object.getPlan().getPlan() == null) {
            object.setPlan(null);
        }
        if (object.getPlan().getPlan().equals(patient.getHealthPlanPatient().getPlanHealthInsurance())) {
            object.setPlan(mapperHealthPlan.toDto(patient.getHealthPlanPatient()));
        }
        if (patient.getAddressPatient().getPostalCode().equals(object.getAddress().getCep())) {
            object.setAddress(mapperAddress.toDto(patient.getAddressPatient()));
        }

        return mapper.toEntity(object);
    }

    public PatientEntity validateDateUpdate(PatientEntity memoryUpdate, PatientEntity searchObject) {
        if (searchObject.getIdPatient() == 0 || memoryUpdate.getCpfPatient().isEmpty() || memoryUpdate.getClinicRegisterPatient() == null) {
            throw new MissingDataException("Falta dados nessa operação");
        }
        if (memoryUpdate.getHealthPlanPatient() != null && searchObject.getHealthPlanPatient() != null) {
            if (memoryUpdate.getHealthPlanPatient().getNumberPlan().equals(searchObject.getHealthPlanPatient().getNumberPlan())) {
                memoryUpdate.setHealthPlanPatient(searchObject.getHealthPlanPatient());
            } else {

                memoryUpdate.getHealthPlanPatient().setIdPlan(searchObject.getHealthPlanPatient().getIdPlan());
            }
        }
        if (memoryUpdate.getAddressPatient() != null) {
            if (memoryUpdate.getAddressPatient().getPostalCode().equals(searchObject.getAddressPatient().getPostalCode())) {
                memoryUpdate.setAddressPatient(searchObject.getAddressPatient());
            } else {
                memoryUpdate.getAddressPatient().setIdAddress(searchObject.getAddressPatient().getIdAddress());

            }

        }

        return memoryUpdate;
    }

    public void preparedRegister(PatientsDto object, HttpServletRequest request) {
        object.setActive(true);
        object.setRegistrationDate(LocalDate.now());
        object.setClinic(validateLogin.validate(request).getClinic());
        validate.validatePatientByCpf(object.getCpf(), object.getClinic().getId());
        save(checkDateNull(object, validateLogin.validate(request).getClinic().getId()));


    }

    public void preparedUpdate(PatientsDto object, HttpServletRequest request) {
        update(mapper.toEntity(object), request);
    }

    @Override
    protected void save(PatientEntity entity) {
        super.save(
                repository.save(entity)
        );
    }

    @Override
    protected void update(PatientEntity entity, HttpServletRequest request) {
        super.update(entity, request);
        PatientEntity searchObject = repository.findByCpfPatientAndClinicRegisterPatient_ClinicId(entity.getCpfPatient(), validateLogin.validate(request).getClinic().getId());
        entity.setClinicRegisterPatient(searchObject.getClinicRegisterPatient());
        save(validateDateUpdate(entity, searchObject));
    }

    @Override
    public List<PatientsDto> searchList(HttpServletRequest object) {
        List<PatientsDto> dtoList = new ArrayList<>();
        for (PatientEntity entity : repository.findAllByClinicRegisterPatient_ClinicId(validateLogin.validate(object).getClinic().getId())) {
            dtoList.add(mapper.toDto(entity));
        }
        return dtoList;
    }

    @Override
    public long count(HttpServletRequest object) {
        return repository.countAllByClinicRegisterPatient_ClinicId(validateLogin.validate(object).getClinic().getId());
    }

    public static void test(SecurityDto s, SecurityDto s1) {
        if (s.equals(s1)) {
            System.out.println("igual");
        }

    }

    public static void main(String[] args) {
        test(new SecurityDto(true, "1", "1"), new SecurityDto(true, "1", "1"));
    }
}
