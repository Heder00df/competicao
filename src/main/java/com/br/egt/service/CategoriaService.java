package com.br.egt.service;

import com.br.egt.entidade.Categoria;
import com.br.egt.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria recuperaCategoriaPorDescricao(String descricao){
        return repo.findByDescricao(descricao);
    }




}
