package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;
import sun.plugin.javascript.navig.LinkArray;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Competicao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competicao")
    private Long id;

    private String nome;

    private String premio;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Liga liga;

    @OneToMany(mappedBy = "competicao", cascade = CascadeType.ALL)
    private List<CompeticaoEquipe> competicaoEquipes;

    @OneToMany(mappedBy = "competicao", cascade = CascadeType.ALL)
    private List<Fase> fases;



}
