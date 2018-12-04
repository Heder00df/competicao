package com.br.egt.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Fase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fase")
    private Long id;

    @Enumerated
    private TipoFase tipoFase;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_jogo")
    private List<Jogo> jogos;

}
