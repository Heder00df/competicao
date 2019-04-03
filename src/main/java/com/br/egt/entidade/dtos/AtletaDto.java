package com.br.egt.entidade.dtos;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.EquipeAtleta;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class AtletaDto implements Serializable {
    private static final long serialVersionUID = 1L;
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
