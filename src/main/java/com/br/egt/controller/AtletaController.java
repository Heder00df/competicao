package com.br.egt.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	@PostMapping("/incluir")
	public AtletaDto salvarAtleta(@RequestBody Atleta atleta) {

		return service.salvar(atleta);

	}
	
	@GetMapping("/atletas")
	public List<Atleta> atletas() {
		List<Atleta> dtoList = service.recuperarAtletas();
		return dtoList;
	}

	@PostMapping("/excluir")
	public List<AtletaDto> excluirAtleta(@RequestBody Long id ){
		service.excluirAtleta(service.recuperarAtletaPorId(id));
		return service.recuperarAtletas().stream().map(at-> new AtletaDto(at)).collect(Collectors.toList());
	}

	@GetMapping("/cpf/{cpf}")
	public AtletaDto recuperarAtletaPorCpf(@PathVariable("cpf") Long cpf){

		return new AtletaDto(service.recuperaAteltaPorCpf(cpf));
	}

}
