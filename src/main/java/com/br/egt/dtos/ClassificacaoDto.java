package com.br.egt.dtos;

import com.br.egt.entidade.Classificacao;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClassificacaoDto {

    private TimeDto time;

    private CompeticaoDto competicao;

    private int pontos;

    private int vitorias;

    private int derrotas;

    private int empates;

    public ClassificacaoDto(Classificacao classificacao) {
        this.competicao = new CompeticaoDto(classificacao.getCompeticao());
        this.time = new TimeDto(classificacao.getTime());
        this.pontos = classificacao.getPontos();
        this.vitorias = classificacao.getVitorias();
        this.derrotas = classificacao.getDerrotas();
        this.empates = classificacao.getEmpates();

    }
}
