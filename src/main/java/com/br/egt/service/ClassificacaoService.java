package com.br.egt.service;

import com.br.egt.dtos.ClassificacaoDto;
import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.dtos.CompeticaoParametro;
import com.br.egt.entidade.*;
import com.br.egt.repositories.CategoriaRepository;
import com.br.egt.repositories.ClassificacaoRepository;
import com.br.egt.repositories.CompeticaoRepository;
import com.br.egt.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassificacaoService {

    @Autowired
    private ClassificacaoRepository repo;


    public Classificacao buscarCompeticaoPorId(Long id){

        Optional<Classificacao> comp = repo.findById(id);

        return comp.get();

    }

    public List<ClassificacaoDto> classificacoesPorSituacaoCompeticao(SituacaoCompeticao situacao) {
        return repo.classificacoesPorSituacaoCompeticao(situacao)
                .stream()
                .map(c-> new ClassificacaoDto(c))
                .collect(Collectors.toList());
    }
}
