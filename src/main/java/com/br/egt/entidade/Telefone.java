package com.br.egt.entidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_telefone")
	private Long id;

	private Long numero;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_atleta")
	private Atleta atleta;

	public Telefone(){};

	public Telefone(Long numero, Atleta atleta) {
		this.numero = numero;
		this.atleta = atleta;
	}
}
