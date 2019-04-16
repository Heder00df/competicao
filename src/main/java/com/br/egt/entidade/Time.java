package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_competicao")
    private Competicao competicao;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    @ManyToMany
    @JoinTable(
            name = "time_atleta",
            joinColumns = { @JoinColumn(name = "id_time") },
            inverseJoinColumns = { @JoinColumn(name = "id_atleta") }
    )
    private Set<Atleta> atletas = new HashSet<>();

    
}
