package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private Long id;

    private  String descricao;

    @OneToMany(mappedBy = "equipe")
    private List<Atleta> atletas;

    @ManyToOne
    @JoinColumn(name = "id_competicao")
    private CompeticaoEquipe competicao;



}