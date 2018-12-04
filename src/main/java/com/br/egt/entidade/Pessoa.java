package com.br.egt.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nome;
	
	@OneToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	private String email;
	
	@OneToMany
	@JoinColumn(name="id_telefone")
	private List<Telefone> telefone;


}
