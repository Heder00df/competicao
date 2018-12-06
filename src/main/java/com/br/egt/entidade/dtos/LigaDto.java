package com.br.egt.entidade.dtos;

import com.br.egt.entidade.Liga;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LigaDto {
    private Long id;
    private String nome;
    private List<String> competicoes;

    public LigaDto(Liga liga) {
        this.id = liga.getId();
        this.nome = liga.getNome();
        this.competicoes = liga.getCompeticoes()
                .stream().map( it->it.getNome()).collect(Collectors.toList());

    }
}
