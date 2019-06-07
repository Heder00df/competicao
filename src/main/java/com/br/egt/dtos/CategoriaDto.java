package com.br.egt.dtos;

import com.br.egt.entidade.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDto {
    private String descricao;
    private Integer idadeMaxima;

    public CategoriaDto(){}

    public CategoriaDto(String descricao, Integer idadeMaxima) {
        this.descricao = descricao;
        this.idadeMaxima = idadeMaxima;
    }

    public CategoriaDto(Categoria categoria) {
        new CategoriaDto(categoria.getDescricao(), categoria.getIdadeMaxima());

    }
}
