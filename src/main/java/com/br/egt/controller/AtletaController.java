package com.br.egt.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
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
		return service.recuperarAtletas();
	}

}
