package com.br.egt.controller;

import com.br.egt.entidade.Jogo;
import com.br.egt.entidade.Time;
import com.br.egt.service.JogoService;
import com.br.egt.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogoController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private JogoService jogoService;

    @GetMapping("/gerar-jogos/competicao/{codigo}")
    public void gerarPartidas(@PathVariable("codigo") Long codigoCompeticao ){
        List<Time> times = timeService.recuperarTimes(codigoCompeticao);
        jogoService.gerarPartidas(times);

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
