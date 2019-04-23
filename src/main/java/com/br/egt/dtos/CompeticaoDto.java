package com.br.egt.dtos;

import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.TipoCompeticao;

public class CompeticaoDto {

    private String nome;

    private String premio;

    private CategoriaDto categoriaDto;

    private Integer temporada;

    private TipoCompeticao tipoCompeticao;

    public CompeticaoDto(Competicao c) {
        this.nome = c.getNome();
        this.premio = c.getPremio();
        this.tipoCompeticao = c.getTipoCompeticao();
    }
}
