package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JogoPK jogoPK = (JogoPK) o;
        return visitante.equals(jogoPK.visitante) &&
                mandante.equals(jogoPK.mandante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitante, mandante);
    }
}
