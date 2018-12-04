package com.br.egt.entidade;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogo")
    private Long id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_campo")
    private Campo campo;
}
