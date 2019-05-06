package com.br.egt.entidade;

import java.util.Arrays;

public enum Divisao {
    PRIMEIRA_DIVISAO("1ª Divisão LUFAS"),
    SEGUNDA_DIVISAO("2ª Divisão LUFAS"),
    BASE("Caterias de base");


    private String descricao;

    Divisao(String descricao) {
        this.descricao = descricao;
    }

    public Divisao getDivisao(String divisao){
        return valueOf(divisao);
    }
}