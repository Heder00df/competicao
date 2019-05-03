package com.br.egt.dtos;

import com.br.egt.entidade.Time;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDto {

    private String nome;
    private Long codigoEquipe;
    private Long codigo;

    public TimeDto(Time time) {
        this.nome = time.getEquipe().getDescricao();
        this.codigo = time.getId();
        this.codigoEquipe = time.getEquipe().getId();
    }
}
