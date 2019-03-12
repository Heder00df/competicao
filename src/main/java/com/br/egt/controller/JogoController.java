package com.br.egt.controller;

import com.br.egt.entidade.Equipe;
import com.br.egt.entidade.Jogo;
import com.br.egt.service.EquipeService;
import com.br.egt.service.JogoService;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
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
        List<Equipe> equipes = equipeService.equipes();
        jogoService.gerarPartidas(equipes);

    }

    @GetMapping("/jogos")
    public List<Jogo> recuperarJogos(){
        return jogoService.recuperarJogos();
    }

    @GetMapping("/rodada/{rodada}")
    public List<Jogo> recuperaJogosPorRodada(@PathVariable("rodada") Integer rodada ){
        return jogoService.recuperaJogosPorRodada(rodada);
    }



}
