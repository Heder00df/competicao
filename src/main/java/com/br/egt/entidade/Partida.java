package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JogoPK pk;

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




}
