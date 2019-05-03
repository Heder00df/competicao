package com.br.egt.service;

import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.entidade.Competicao;
import com.br.egt.repositories.CategoriaRepository;
import com.br.egt.repositories.CompeticaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Competicao buscarCompeticaoPorId(Long id){

        Optional<Competicao> comp = repo.findById(id);

        return comp.get();

    }

    public Competicao salvarCompeticao(CompeticaoDto dto){


        Competicao competicao = new Competicao();
        competicao.setNome(dto.getNome());
        competicao.setTipoCompeticao(dto.getTipoCompeticao());
        competicao.setCategoria(categoriaRepository.findByDescricao(dto.getCategoria().getDescricao()));
        competicao.setTimes();


        return repo.save(competicao);
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
