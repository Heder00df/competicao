package com.br.egt.controller;

import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.dtos.CompeticaoParametro;
import com.br.egt.entidade.Competicao;
import com.br.egt.service.CompeticaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competicao")
public class CompeticaoController {

    @Autowired
    private CompeticaoService service;

    @PostMapping("/inserir")
    public List<CompeticaoDto> salvarCompeticao(@RequestBody CompeticaoParametro parametro){
        service.salvarCompeticao(parametro);
        return service.buscarTodasCompeticoes();
    }

    @PostMapping("/excluir")
    public List<CompeticaoDto> excluirCompeticao(@RequestBody CompeticaoDto competicao){
        return service.excluir(competicao.getCodigo());
    }

    @GetMapping("/competicoes")
    public List<CompeticaoDto> competicoes(){
        return service.buscarTodasCompeticoes();

    }

    public List<CompeticaoDto> competicoesEmAndamento(){
        return service.competicoesEmAndamento();
    }
}
