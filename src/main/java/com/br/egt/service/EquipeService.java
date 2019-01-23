package com.br.egt.service;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Equipe;
import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.repositories.AtletaRepository;
import com.br.egt.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository rep;

    public Equipe salvar(Equipe equipe) {
        return rep.save(equipe);
    }

    public List<Equipe> recuperarEquipes() {
        return rep.findAll();
    }

    public void excluir(Equipe equipe) {
        rep.delete(equipe);
    }
}
