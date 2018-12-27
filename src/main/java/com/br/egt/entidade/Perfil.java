package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.swing.*;
@Getter
public enum  Perfil {
    GESTOR_SISTEMA(34),DIRETOR_LIGA(36),DIRETOR_EQUIPE(38);

    private Integer codigo;


    Perfil(Integer codigoPerfil) {
        this.codigo = codigoPerfil;
    }


}
