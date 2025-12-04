package com.github.sync.odontolocico.validate;

import com.github.sync.odontolocico.dto.TokenDto;
import com.github.sync.odontolocico.handle.exception.ClientNotFoundException;
import com.github.sync.odontolocico.handle.exception.InvalidTokenException;
import com.github.sync.odontolocico.jwt.JwtUtil;
import com.github.sync.odontolocico.mapper.TokenMapper;
import com.github.sync.odontolocico.repository.TokenRegisterRepository;
import org.springframework.stereotype.Component;

@Component
public class TokenValidate {
    private final TokenRegisterRepository repository;
    private final JwtUtil util;
    private final TokenMapper mapper;
    public TokenValidate(TokenRegisterRepository repository, JwtUtil util, TokenMapper mapper) {
        this.repository = repository;
        this.util = util;
        this.mapper = mapper;
    }
    public TokenDto validateSearchTokenClinic(String token){
        TokenDto memoryDto = mapper.toDto(repository.findByValueToken(token));
        if(memoryDto == null){
            throw new  InvalidTokenException("Token de clinica nova inexostente");
        }
        return memoryDto;
    }
    public TokenDto validateSearchTokenByEmail(String token){
        TokenDto memoryDto = mapper.toDto(repository.findByClient_EmailClient(util.getUsernameFromToken(token)));
        if(memoryDto == null){
            throw new  InvalidTokenException("Token de clinica nova inexostente");
        }
        return memoryDto;
    }

    public void validate(String tokenClinic, String tokenAuth) {
         TokenDto memory = validateSearchTokenClinic(tokenClinic);
        if(!memory.getClient().getEmail().equals(util.getUsernameFromToken(tokenAuth))){
            throw new ClientNotFoundException("Cliente não encontrado");
        }
    }


}
