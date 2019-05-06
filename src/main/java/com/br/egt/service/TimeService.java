package com.br.egt.service;

import com.br.egt.dtos.TimeDto;
import com.br.egt.entidade.Categoria;
import com.br.egt.entidade.Time;
import com.br.egt.entidade.Divisao;
import com.br.egt.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repo;


    public List<Time> recuperarTimes(Long codigoCompeticao){
        return repo.recuperarTimesPorCompeticao(codigoCompeticao);
    }

    public List<TimeDto> recuperarTimesPorCategoriaEDivisao(Categoria categoria, Divisao divisao){
        List<Time> times = repo.findByCategoriaAndDivisao(categoria, divisao);

        return  times.stream().map(time -> new TimeDto(time)).collect(Collectors.toList());
    }
}
