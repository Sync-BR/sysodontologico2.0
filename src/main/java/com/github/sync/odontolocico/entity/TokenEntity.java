package com.github.sync.odontolocico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.SecureRandom;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TOKEN_REGISTER")
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;
    private String valueToken;
    private boolean isActive;
    private LocalDate createdDate;
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "clientId")
    private ClientEntity client;

    public TokenEntity() {
    }


}
