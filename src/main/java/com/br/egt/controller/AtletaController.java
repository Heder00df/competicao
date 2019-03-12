package com.br.egt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.br.egt.entidade.Endereco;
import com.br.egt.entidade.Telefone;
import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import com.br.egt.entidade.Atleta;

@RestController
@RequestMapping(value = "/atleta")
public class AtletaController {

	@Autowired
	private AtletaService service;

	@PostMapping(value = "/incluir")
	public AtletaDto salvarAtleta(@RequestBody AtletaDto atleta) {

		return service.salvar(atleta);

	}
	
	@GetMapping("/atletas")
	public List<Atleta> atletas() {
		Atleta a = new Atleta();
		a.setPosicao("Lateral");
		a.setCpf(69338969172L);
		a.setNome("Heder Machado");
		a.setIdentidade(1895541L);

		Telefone tel  = new Telefone();
		tel.setNumero(34593824L);
		tel.setId(1L);
		a.setTelefones(Arrays.asList(tel));

		Endereco end = new Endereco();
		end.setComplemento("Apartamento");
		end.setNumero(304L);
		end.setLogradouro("Quadra 301 Conjunto 07 lotes 01/06 Bloco C");
		a.setEndereco(end);

		//List<Atleta> dtoList = service.recuperarAtletas();
		return Arrays.asList(a);
	}

	@PostMapping("/excluir")
	public List<AtletaDto> excluirAtleta(@Param("id") Long id ){
		service.excluirAtleta(service.recuperarAtletaPorId(id));
		return service.recuperarAtletas().stream().map(at-> new AtletaDto(at)).collect(Collectors.toList());
	}

	@GetMapping("/cpf/{cpf}")
	public AtletaDto recuperarAtletaPorCpf(@PathVariable("cpf") Long cpf){
		return new AtletaDto(service.recuperaAteltaPorCpf(cpf));
	}

}
