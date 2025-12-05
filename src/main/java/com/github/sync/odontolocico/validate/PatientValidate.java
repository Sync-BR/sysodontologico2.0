package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.handle.exception.ClinicPatientExisting;
import com.github.sync.odontolocico.interfaces.Validator;
import com.github.sync.odontolocico.repository.PatientRepository;
import org.springframework.stereotype.Component;

@Component
public class PatientValidate extends Validator<String> {
    private final PatientRepository repository;

    public PatientValidate(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validatePatientByCpf(String cpf, Long clinicId) {
        if(repository.findByCpfPatientAndClinicRegisterPatient_ClinicId(cpf, clinicId) !=  null){
            throw new ClinicPatientExisting("Paciente já adicionado na clinica!");
        }
    }
}
