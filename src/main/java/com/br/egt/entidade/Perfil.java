package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.swing.*;
@Getter
public enum  Perfil {
    GESTOR_SISTEMA(34,"ROLE_GS"),
    DIRETOR_LIGA(36, "ROLE_DL"),
    DIRETOR_EQUIPE(38,"ROLE_DE");

    private Integer codigo;
    private String descricao;


    Perfil(Integer codigoPerfil, String descricao) {
        this.descricao = descricao;
        this.codigo = codigoPerfil;
    }


}
