package com.br.egt.entidade;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class EquipeAtleta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_atlera")
    private Atleta atleta;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    private String anoAtuacao;
}
