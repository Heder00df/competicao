package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;
import sun.plugin.javascript.navig.LinkArray;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Competicao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String premio;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Liga liga;

    @OneToMany(mappedBy = "id.competicao",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<CompeticaoCategoria>  competicoesCategorias = new HashSet<>();

    @Enumerated(EnumType.STRING )
    @Column(name = "tipo_campeonato")
    private TipoCompeticao tipoCompeticao;

    @OneToMany(mappedBy = "id.competicao", fetch = FetchType.EAGER)
    private Set<Time> times = new HashSet<>();

    @OneToMany(mappedBy = "competicao", cascade = CascadeType.ALL)
    private List<Fase> fases;


}
