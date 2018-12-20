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

    public Equipe getVisitante(){
        return pk.getVisitante();
    }
    public Equipe getMandante(){
        return pk.getMandante();
    }
    public void setVisitante(Equipe visitante){
        pk.setVisitante(visitante);
    }
    public void setMandante(Equipe mandante){
        pk.setMandante(mandante);
    }




}
