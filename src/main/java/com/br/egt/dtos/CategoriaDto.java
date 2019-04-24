package com.br.egt.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDto {
    private String descricao;
    private Integer idadeMaxima;

    public CategoriaDto(String descricao, Integer idadeMaxima) {
        this.descricao = descricao;
        this.idadeMaxima = idadeMaxima;
    }
}
