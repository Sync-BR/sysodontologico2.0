package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.dto.DentistDto;
import com.github.sync.odontolocico.handle.exception.ClinicDentisCpfExisting;
import com.github.sync.odontolocico.handle.exception.ClinicDentisEmailExisting;
import com.github.sync.odontolocico.interfaces.Validator;
import com.github.sync.odontolocico.repository.DentistRepository;
import org.springframework.stereotype.Component;

@Component
public class DentistValidate extends Validator<String> {
    private final DentistRepository repository;

    public DentistValidate(DentistRepository repository) {
        this.repository = repository;
    }

    public void validateRegister(String cpf, String email, Long clinicId) {
        validateDentistByCpf(cpf, clinicId);
        validateDentistByEmail(email, clinicId);
    }

    @Override
    public void validateDentistByCpf(String cpf, Long clinicId) {
        if (repository.findByDentistCpfAndDentistClinic_ClinicId(cpf, clinicId) != null) {
            throw new ClinicDentisCpfExisting("Dentista já está cadastrado com esse cpf");
        }
    }

    @Override
    public void validateDentistByEmail(String email, Long clinicId) {
        if (repository.findByDentistEmailAndDentistClinic_ClinicId(email, clinicId) != null) {
            throw new ClinicDentisEmailExisting("Dentista já está cadastrado com esse email");
        }
    }
}
