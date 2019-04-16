package com.br.egt.service;

import com.br.egt.entidade.Time;
import com.br.egt.repositories.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private TimeRepository repo;


    public List<Time> recuperarTimes(Long codigoCompeticao){
        return repo.recuperarTimesPorCompeticao(codigoCompeticao);
    }
}
