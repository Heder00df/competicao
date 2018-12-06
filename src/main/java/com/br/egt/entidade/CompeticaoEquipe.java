package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class CompeticaoEquipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competicao_equipe")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_competicao")
    private Competicao competicao;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;



}
