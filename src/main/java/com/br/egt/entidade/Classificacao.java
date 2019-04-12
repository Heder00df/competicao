package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Classificacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontos;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;







}
