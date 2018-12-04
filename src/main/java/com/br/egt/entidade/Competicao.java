package com.br.egt.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Competicao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competicao")
    private Long id;

    private String nome;

    private String premio;

    @OneToMany
    @JoinColumn(name = "id_equipe")
    private List<Equipe> equipes;

    @OneToMany
    @JoinColumn(name = "id_fase")
    private List<Fase> fases;

}
