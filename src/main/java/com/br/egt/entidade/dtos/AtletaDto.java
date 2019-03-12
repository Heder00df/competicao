package com.br.egt.entidade.dtos;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Equipe;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AtletaDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cpf;
    private String nome;
    private String dataNascimento;
    private Long identidade;
    private String posicao;
    private String logradouro;
    private String complemento;
    private Long numero;
    private Long telefoneFixo;
    private Long telefoneCelular;
    private String nomeEquipe;
    private Long codigoEquipe;

    public AtletaDto(){}

    public AtletaDto(Atleta atleta) {
        this.cpf = atleta.getCpf();
        this.nome = atleta.getNome();
        this.identidade = atleta.getIdentidade();
        this.posicao = atleta.getPosicao();
        this.nomeEquipe = atleta.getEquipe().getDescricao();
        this.codigoEquipe = atleta.getEquipe().getId();
    }
}
