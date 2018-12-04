package com.br.egt.entidade;

public enum TipoFase {
    PRIMEIRA_FASE(1),
    SEGUNDA_FASA(2),
    OITAVAS(8),
    QUARTAS(4),
    SEMI(2),
    FINAL(0);

    private Integer valor;

    TipoFase(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }
}
