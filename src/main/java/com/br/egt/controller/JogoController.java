package com.br.egt.controller;

import com.br.egt.entidade.Equipe;
import com.br.egt.service.EquipeService;
import com.br.egt.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private JogoService jogoService;

    @GetMapping("/gerar-jogos")
    public void gerarPartidas(){
        List<Equipe> visitantes = equipeService.recuperarEquipes();

        List<Equipe> mandante = equipeService.recuperarEquipes();


        jogoService.gerarPartidas(mandante, visitantes);

    }
}
