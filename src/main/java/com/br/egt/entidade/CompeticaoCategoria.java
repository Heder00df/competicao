package com.br.egt.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class CompeticaoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CompeticaoCategoriaPK id = new CompeticaoCategoriaPK();

}

