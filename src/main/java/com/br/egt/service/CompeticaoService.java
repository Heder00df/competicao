package com.br.egt.service;

import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.dtos.CompeticaoParametro;
import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.Divisao;
import com.br.egt.entidade.Time;
import com.br.egt.repositories.CategoriaRepository;
import com.br.egt.repositories.CompeticaoRepository;
import com.br.egt.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private TimeRepository timeRepository;

    public Competicao buscarCompeticaoPorId(Long id){

        Optional<Competicao> comp = repo.findById(id);

        return comp.get();

    }

    public List<CompeticaoDto> excluir(Long id) {
        repo.delete(repo.findById(id).get());
        return buscarTodasCompeticoes();
    }

    public Competicao salvarCompeticao(CompeticaoParametro parametro){
        Competicao nova =  new Competicao();
        nova.setCategoria(categoriaRepository.findByDescricao(parametro.getCategoria()));
        nova.setTipoCompeticao(Divisao.valueOf(parametro.getDivisao()));
        nova.setNome(parametro.getNome());
        nova.setTemporada(LocalDate.now().getYear());
        Set<Time> times = new HashSet<>();

        parametro.getCodigosTimes().stream().forEach( time ->
                times.add(timeRepository.findById(time).get())
        );

        nova.setTimes(times);

        return repo.save(nova);
    }


    public List<CompeticaoDto> buscarTodasCompeticoes() {
        return converterParaDto(repo.findAll());
    }

    private List<CompeticaoDto> converterParaDto(List<Competicao> all) {
        if(all != null){
            return all.stream().map(c-> new CompeticaoDto(c)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
