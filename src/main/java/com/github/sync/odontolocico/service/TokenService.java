package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.dto.TokenDto;
import com.github.sync.odontolocico.entity.TokenEntity;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.mapper.TokenMapper;
import com.github.sync.odontolocico.repository.ClientRepository;
import com.github.sync.odontolocico.repository.TokenRegisterRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TokenService extends ServiceImp<TokenEntity,TokenDto> {
    private final  TokenRegisterRepository repository;
    private final ClientRepository repositoryClient;
    public final TokenMapper mapper;
    public TokenService(TokenRegisterRepository repository, ClientRepository repositoryClient, TokenMapper mapper) {
        this.repository = repository;
        this.repositoryClient = repositoryClient;
        this.mapper = mapper;
    }
    ///  Criar uma validação para buscar o id do usuário!
    public String registerTokenClinic(ClientDto memoryClient) {
        TokenDto token = new TokenDto(memoryClient,true, LocalDate.now());
        save(mapper.toEntity(token));
        return token.getToken();
    }

    public void disableToken(String token) {
        TokenEntity memory = repository.findByValueToken(token);
        memory.setActive(false);
        save(memory);
    }

    @Override
    protected void update(TokenEntity entity, HttpServletRequest request) {
        save(entity);
    }

    @Override
    protected void save(TokenEntity entity) {
        repository.save(entity);
    }
}
