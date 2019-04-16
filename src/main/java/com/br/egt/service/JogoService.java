package com.br.egt.service;

import com.br.egt.entidade.Jogo;
import com.br.egt.entidade.Time;
import com.br.egt.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repo;

    public List<Jogo> recuperarJogos() {
        return repo.findAll();
    }

    public List<Jogo> recuperaJogosPorRodada(Integer rodada){
        return  repo.recuperaJogosPorRodada(rodada);
    }

    public void gerarPartidas(List<Time> Times) {

        Collections.shuffle(Times);

        if (Times.size() % 2 == 0) {

            gerarConfrontosPar(Times);

        } else {

            gerarConfrontosImpar(Times);

        }
    }

    private void gerarConfrontosPar(List<Time> times) {
        List<Jogo> jogos = new ArrayList<>();
        int quantidadeTimes = times.size();
        int quantidadeConfrontosPorPartida = times.size() / 2;
        for (int i = 0; i < quantidadeTimes - 1; i++) {
            for (int j = 0; j < quantidadeConfrontosPorPartida; j++) {
                if (times.get(j).getEquipe().getDescricao().isEmpty()) {
                    continue;
                }

                if (j % 2 == 1 || i % 2 == 1 && j == 0) {
                    jogos.add(new Jogo(times.get(quantidadeTimes - j - 1), times.get(j), i + 1));
                } else {
                    jogos.add(new Jogo(times.get(j), times.get(quantidadeTimes - j - 1), i + 1));
                }
            }
            times.add(1, times.remove(times.size() - 1));
        }
        repo.saveAll(jogos);
    }

    private void gerarConfrontosImpar(List<Time> times) {
        List<Jogo> jogos = new ArrayList<>();
        int quantidadeTimes = times.size();
        int quantidadeConfrontosPorPartida = times.size() / 2;
        for (int i = 0; i < quantidadeTimes; i++) {
            for (int j = 0; j < quantidadeConfrontosPorPartida; j++) {
                if (times.get(j).getEquipe().getDescricao().isEmpty()) {
                    continue;
                }
                if (j % 2 == 1 || i % 2 == 1 && j == 0) {
                    jogos.add(new Jogo(times.get(quantidadeTimes - j - 1), times.get(j), i + 1));
                } else {
                    jogos.add(new Jogo(times.get(j), times.get(quantidadeTimes - j - 1), i + 1));
                }
            }
            times.add(0, times.remove(times.size() - 1));
        }
        repo.saveAll(jogos);
    }

}
