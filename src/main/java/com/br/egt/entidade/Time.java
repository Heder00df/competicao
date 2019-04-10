package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    TimePk id = new TimePk();

    @OneToOne
    private Classificacao classificacao;

}
