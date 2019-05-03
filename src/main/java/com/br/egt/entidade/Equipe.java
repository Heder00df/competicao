package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String descricao;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private List<Atleta> atletas = new ArrayList<>();

    @OneToMany(mappedBy = "equipe")
    private List<Time> times = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Equipe(String descricao, Long id) {
        this.id = id;
        this.descricao = descricao;
    }


    public Equipe() {
    }
}
