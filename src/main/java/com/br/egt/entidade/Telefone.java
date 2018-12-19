package com.br.egt.entidade;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_telefone")
	private Long id;

	private Long numero;

	@ManyToOne
	@JoinColumn(name = "id_atleta")
	private Atleta atleta;
	
}
