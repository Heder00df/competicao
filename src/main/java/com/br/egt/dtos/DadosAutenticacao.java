package com.br.egt.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosAutenticacao {
    private String username;
    private String password;
    private Long codRecursoComputacional;
}
