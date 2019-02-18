package com.br.egt.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	



}
