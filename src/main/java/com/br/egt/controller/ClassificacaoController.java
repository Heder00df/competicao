package com.br.egt.controller;

import com.br.egt.dtos.ClassificacaoDto;
import com.br.egt.entidade.SituacaoCompeticao;
import com.br.egt.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService service;

    @GetMapping("/classificacoes/situacao/{situacao}")
    public List<ClassificacaoDto> classificacoesAndamento(@PathVariable("situacao") String situacao){
        SituacaoCompeticao sit = SituacaoCompeticao.valueOf(situacao);
        return service.classificacoesPorSituacaoCompeticao(sit);

    }
}
