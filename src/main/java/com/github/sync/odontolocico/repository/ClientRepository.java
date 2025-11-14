package com.github.sync.odontolocico.repository;

import com.github.sync.odontolocico.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
    ClientEntity findByEmailClient(String emailClient);
    ClientEntity findByCpfClient(String cpfClient);
}
