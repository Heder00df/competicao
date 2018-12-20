package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class JogoPK implements Serializable {
    public JogoPK(){}
    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Equipe visitante;
    @ManyToOne
    @JoinColumn(name = "mandate_id")
    private Equipe mandante;
}
