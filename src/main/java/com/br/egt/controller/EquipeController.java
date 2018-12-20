package com.br.egt.controller;

import com.br.egt.entidade.Equipe;
import com.br.egt.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private EquipeService service;

	@PostMapping("/incluir")
	public Equipe salvarAtleta(@RequestBody Equipe equipe) {
		return service.salvar(equipe);

	}
	
	@GetMapping("/equipes")
	public List<Equipe> atletas() {
		return service.recuperarEquipes();
	}

}
