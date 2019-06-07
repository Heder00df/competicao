package com.br.egt.entidade;

import lombok.Getter;

@Getter
public enum  SituacaoCompeticao {
    ATIVO("Ativo"),
    EXCLUIDO("Excluído"),
    FINALIZADO("Finalizado");

    private String descricao;
    SituacaoCompeticao(String situcao){
        this.descricao=situcao;
    }

}
