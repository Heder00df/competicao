package com.br.egt.controller;

import com.br.egt.entidade.Equipe;
import com.br.egt.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private EquipeService service;

	@PostMapping(value = "/incluir")
	public Equipe salvarEquipe(@RequestBody Equipe equipe) {
		return service.salvar(equipe);

	}

	@PostMapping("/excluir")
	public List<Equipe> excluirEquipe(@RequestBody Equipe equipe) {
		service.excluir(equipe);
		return service.recuperarEquipes();
	}


	@GetMapping("/equipes")
	public List<Equipe> equipes() {
		//Equipe e  = new Equipe();
		//e.setDescricao("Panelinha");
		return service.recuperarEquipes();
		//return Arrays.asList(e);
	}

}
