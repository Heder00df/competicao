package com.br.egt.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.br.egt.dtos.EquipeDTO;
import com.br.egt.entidade.Cliente;
import com.br.egt.entidade.Equipe;
import com.br.egt.service.ClienteService;
import com.br.egt.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private EquipeService service;

	@Autowired
	private ClienteService clienteService;

	@PostMapping(value = "/incluir")
	public EquipeDTO salvarEquipe(@RequestBody EquipeDTO equipe, HttpServletRequest req) {

		String token = req.getHeader("Authorization").substring(7);

		DecodedJWT jwt = JWT.decode(token);

		Long id = jwt.getClaim("codigoCliente").asLong();

		Cliente cli = clienteService.recuperarClientePorId(id);

		return service.salvar(equipe, cli);

	}

	@PostMapping("/excluir")
	public List<EquipeDTO> excluirEquipe(@RequestBody Equipe equipe) {
		service.excluir(equipe);
		return service.recuperarEquipes();
	}


	@GetMapping("/equipes")
	public List<EquipeDTO> atletas() {
		return service.recuperarEquipes();
	}

}
