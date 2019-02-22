package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
import javax.swing.*;

public enum  Perfil {
    GESTOR_SISTEMA(34,"ROLE_ADMIN"),
    DIRETOR_LIGA(36, "ROLE_DTL"),
    DIRETOR_EQUIPE(38,"ROLE_DTE");

    private Integer codigo;

    private String descricao;


    Perfil(Integer codigoPerfil, String descricao) {
        this.descricao = descricao;
        this.codigo = codigoPerfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null ){
            return null;
        }
        for (Perfil perfil:Perfil.values()){
            if(cod.equals(perfil.codigo)){
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil inválido: "+ cod);
    }


}
