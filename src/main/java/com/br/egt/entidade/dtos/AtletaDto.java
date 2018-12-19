package com.br.egt.entidade.dtos;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.EquipeAtleta;

import java.time.LocalDate;
import java.util.List;

public class AtletaDto {

    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Long rg;
    private String posicao;


    public AtletaDto(Atleta atleta) {
        this.cpf = atleta.getCpf();
        this.nome = atleta.getNome();
        this.dataNascimento = atleta.getDataNascimento();
        this.rg = atleta.getRg();
        this.posicao = atleta.getPosicao();
    }
}
