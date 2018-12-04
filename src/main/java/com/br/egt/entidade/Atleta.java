package com.br.egt.entidade;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
public class Atleta extends PessoaFisica {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atleta")
	private Long id;
	private String posicao;

	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
}
