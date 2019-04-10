package com.br.egt.entidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Atleta extends PessoaFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String posicao;

	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;

	@JsonBackReference
	@OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<>();

}
