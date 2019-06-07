package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class Classificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "competicao_id")
    private Competicao competicao;

    private int pontos;

    private int vitorias;

    private int derrotas;

    private int empates;
}
