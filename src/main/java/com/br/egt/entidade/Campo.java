package com.br.egt.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Campo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "campo", orphanRemoval = true)
    private List<Jogo> jogos;
}
