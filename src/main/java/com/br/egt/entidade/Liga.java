package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Liga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "liga")
    private List<Competicao> competicoes;

    public List<Competicao> getCompeticoes(){
        if(competicoes == null)
            return new ArrayList<>();
        return competicoes;

    }

}
