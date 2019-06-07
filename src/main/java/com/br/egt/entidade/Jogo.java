package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JogoPK pk = new JogoPK();

    private LocalDate data;

    private Integer rodada;
    
    @ManyToOne
    @JoinColumn(name = "id_campo")
    private Campo campo;

    @Enumerated
    private Resultado resultado;

    private Integer placarTimeVisitante;

    private Integer placarTimeMandante;


    public Jogo(){}

    public Jogo(Time mandante, Time visitante, Integer rodada){
        setMandante(mandante);
        setVisitante(visitante);
        setRodada(rodada);
    }


    public Time getVisitante(){
        return pk.getVisitante();
    }
    public Time getMandante(){
        return pk.getMandante();
    }
    public void setVisitante(Time visitante){
        pk.setVisitante(visitante);
    }
    public void setMandante(Time mandante){
        pk.setMandante(mandante);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return pk.equals(jogo.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk);
    }

}
