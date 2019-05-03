package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Integer temporada;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Liga liga;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Enumerated(EnumType.STRING )
    @Column(name = "tipo_campeonato")
    private Divisao tipoCompeticao;

    @OneToMany(mappedBy = "competicao", fetch = FetchType.EAGER)
    private Set<Time> times = new HashSet<>();

    @OneToMany(mappedBy = "competicao", cascade = CascadeType.ALL)
    private List<Fase> fases;


}
