package com.br.egt.entidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
public class Atleta extends PessoaFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atleta")
	private Long id;
	private String posicao;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "atleta")
	private List<EquipeAtleta> equipe;

	@JsonBackReference
	@OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL)
	private List<Telefone> telefones;

}
