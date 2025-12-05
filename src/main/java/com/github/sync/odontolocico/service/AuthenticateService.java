package com.github.sync.odontolocico.service;

import com.github.sync.odontolocico.dto.ClientDto;
import com.github.sync.odontolocico.entity.ClientEntity;
import com.github.sync.odontolocico.interfaces.ServiceImp;
import com.github.sync.odontolocico.jwt.JwtUtil;
import com.github.sync.odontolocico.validate.ClientValidate;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService extends ServiceImp<ClientEntity, ClientDto> {
    private final JwtUtil util;
    private final ClientValidate validateClient;

    public AuthenticateService(JwtUtil util, ClientValidate validateClient) {
        this.util = util;
        this.validateClient = validateClient;
    }

    public String authenticate(ClientDto memory) {
        validateClient.validateLogin(memory) ;
        return util.generateToken(memory.getEmail());
    }
}
