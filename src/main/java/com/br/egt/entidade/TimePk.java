package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Setter
@Getter
public class TimePk implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_competicao")
    private Competicao competicao;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

}
