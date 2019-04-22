package com.br.egt.dtos;

import com.br.egt.entidade.Equipe;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EquipeDTO {
    private String descricao;
    private Long id;
    private String email;
    private Long idUsuario;

    public EquipeDTO(){}

    public EquipeDTO(Long id, String descricao, String email, Long codigoUsuario) {
        this.id = id;
        this.descricao = descricao;
        this.email = email;
        this.idUsuario = codigoUsuario;
    }

    public EquipeDTO(Equipe equipe) {
        this.id = equipe.getId();
        this.descricao = equipe.getDescricao();
        this.email = equipe.getUsuario().getEmail();
        this.idUsuario = equipe.getUsuario().getId();

    }
}
