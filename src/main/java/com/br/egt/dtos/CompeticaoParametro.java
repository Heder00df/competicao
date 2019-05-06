package com.br.egt.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CompeticaoParametro {
    private String categoria;
    private String divisao;
    private String nome;
    private List<Long> codigosTimes;
}
