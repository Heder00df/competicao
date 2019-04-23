package com.br.egt.controller;

import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.entidade.Competicao;
import com.br.egt.service.CompeticaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competicao")
public class CompeticaoController {

    @Autowired
    private CompeticaoService service;

    @PostMapping("/inserir")
    public Competicao salvarCompeticao(@RequestBody Competicao competicao){
        service.salvarCompeticao(competicao);
        return competicao;
    }

    @GetMapping("/competicoes")
    public List<CompeticaoDto> competicoes(){
        return service.buscarTodasCompeticoes();

    }
}
