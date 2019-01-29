package com.br.egt.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenServico {
    private String token;

    public TokenServico(String token) {
        this.token = token;

    }
}
