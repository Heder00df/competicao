package com.br.egt.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Liga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liga")
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_competicao")
    private List<Competicao> competicoes;

}
