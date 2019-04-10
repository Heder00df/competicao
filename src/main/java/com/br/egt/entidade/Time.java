package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    TimePk id = new TimePk();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "time_atleta",
            joinColumns = { @JoinColumn(name = "id_time") },
            inverseJoinColumns = { @JoinColumn(name = "id_atleta") }
    )
    Set<Atleta> atletas = new HashSet<>();

    
}
