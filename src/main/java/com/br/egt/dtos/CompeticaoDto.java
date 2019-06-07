package com.br.egt.dtos;

import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.Divisao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompeticaoDto {

    private Long codigo;

    private String nome;

    private String premio;

    private CategoriaDto categoria;

    private Integer temporada;

    private Divisao tipoCompeticao;

    private String situacao;

    public CompeticaoDto() {}

    public CompeticaoDto(Competicao c) {
        this.nome = c.getNome();
        this.codigo = c.getId();
        this.premio = c.getPremio();
        this.temporada = c.getTemporada();
        this.tipoCompeticao = c.getTipoCompeticao();
        this.situacao = c.getSituacao().getDescricao();
        this.categoria = new CategoriaDto(c.getCategoria().getDescricao(), c.getCategoria().getIdadeMaxima());
    }
}
