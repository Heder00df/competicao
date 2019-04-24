package com.br.egt.dtos;

import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.TipoCompeticao;
import lombok.Getter;

@Getter
public class CompeticaoDto {

    private String nome;

    private String premio;

    private CategoriaDto categoria;

    private Integer temporada;

    private TipoCompeticao tipoCompeticao;

    public CompeticaoDto(Competicao c) {
        this.nome = c.getNome();
        this.premio = c.getPremio();
        this.temporada = c.getTemporada();
        this.tipoCompeticao = c.getTipoCompeticao();
        this.categoria = new CategoriaDto(c.getCategoria().getDescricao(), c.getCategoria().getIdadeMaxima());
    }
}
