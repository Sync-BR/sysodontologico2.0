package com.github.sync.odontolocico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;
    private String postalCode;      // cep
    private String street;          // logradouro
    private String complement;      // complemento
    private String district;        // bairro
    private String city;            // localidade
    private String state;           // uf
    private String number;          // número informado pelo usuário
}
