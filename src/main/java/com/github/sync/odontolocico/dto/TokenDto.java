package com.github.sync.odontolocico.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.SecureRandom;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class TokenDto {
    private long id;
    private String token;
    private boolean active;
    private LocalDate createdDate;
    private ClientDto client;

    private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String ALL = UPPER + LOWER + NUMBERS;
    private final SecureRandom random = new SecureRandom();

    public TokenDto(ClientDto client ,boolean active, LocalDate createdDate) {
        this.client = client;
        this.token = generateSecureToken(64);
        this.active = active;
        this.createdDate = createdDate;
    }

    public String generateSecureToken(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL.length());
            sb.append(ALL.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TokenDto dto = new TokenDto(null, true, LocalDate.now());
        System.out.println(dto);
    }
}
