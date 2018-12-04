package com.br.egt.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
}
