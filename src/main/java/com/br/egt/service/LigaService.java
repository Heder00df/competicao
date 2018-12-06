package com.br.egt.service;

import com.br.egt.entidade.Liga;
import com.br.egt.repositories.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigaService {

    @Autowired
    private LigaRepository repository;

    public Liga salvarLiga(Liga liga){
        return repository.save(liga);
    }

    public Liga recuperarPorId(Long codigo) {
        return repository.findById(codigo).get();

    }
}
