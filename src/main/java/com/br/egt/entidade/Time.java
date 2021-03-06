package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy ="pk.visitante", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Jogo> jogosVisitante = new ArrayList<>();

    @OneToMany(mappedBy ="pk.mandante", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Jogo> jogosMandante = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Enumerated(EnumType.STRING )
    @Column(name = "divisao")
    private Divisao divisao;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "time_atleta",
            joinColumns = { @JoinColumn(name = "id_time") },
            inverseJoinColumns = { @JoinColumn(name = "id_atleta") }
    )
    private Set<Atleta> atletas = new HashSet<>();

    
}
