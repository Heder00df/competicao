package com.br.egt.service;

import com.br.egt.entidade.Equipe;
import com.br.egt.entidade.Jogo;
import com.br.egt.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repo;
    public void gerarPartidas(List<Equipe> mandantes, List<Equipe> visitantes) {
        List<Jogo> jogos = new ArrayList<>();
        for (Equipe mandante: mandantes) {
            for (Equipe visitante: visitantes ) {
                if(mandante.getDescricao() != visitante.getDescricao()){
                    Jogo jogo = new Jogo(visitante, mandante);
                    if(!existeJogo(jogos, jogo)){
                        jogos.add(new Jogo(mandante, visitante));
                    }
                }

            }

        }
        for (Jogo jogo: jogos) {


        }
         repo.saveAll(jogos);

    }

    private boolean existeJogo(List<Jogo> jogos, Jogo jogo) {
        for (Jogo j:jogos ) {
            if(j.getPk().getMandante().equals(jogo.getPk().getMandante())
                    && j.getPk().getVisitante().equals(jogo.getPk().getVisitante()) ){
                return true;
            }

        }
        return false;
    }
}
