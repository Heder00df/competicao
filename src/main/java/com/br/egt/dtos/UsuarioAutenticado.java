package com.br.egt.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioAutenticado {
    private TokenServico tokenServico;

    public UsuarioAutenticado(TokenServico tokenServico) {
        this.tokenServico = tokenServico;
    }
}
