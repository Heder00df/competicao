package com.br.egt.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private Long id;

    @OneToMany(mappedBy = "equipe")
    private List<Atleta> atletas;





}
