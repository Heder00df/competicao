package com.br.egt.entidade;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;
	private Long cpf;
	private LocalDate dataNascimento;
	private Long rg;
	
}
