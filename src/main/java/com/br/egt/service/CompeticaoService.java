package com.br.egt.service;

import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.Liga;
import com.br.egt.repositories.CompeticaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository repo;

    public Competicao buscarCompeticaoPorId(Long id){

        Optional<Competicao> comp = repo.findById(id);

        return comp.get();

    }

    public Competicao salvarCompeticao(Competicao competicao){
        return repo.save(competicao);
    }


}
