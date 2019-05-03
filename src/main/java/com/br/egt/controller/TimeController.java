package com.br.egt.controller;

import com.br.egt.dtos.TimeDto;
import com.br.egt.entidade.Categoria;
import com.br.egt.entidade.Divisao;
import com.br.egt.entidade.Time;
import com.br.egt.service.CategoriaService;
import com.br.egt.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private CategoriaService categoriaServico;

    @GetMapping("/categoria/{categoria}/divisao/{divisao}")
    public List<TimeDto> recuperarTimesPorCategoriaEDivisao(
            @PathVariable("categoria") String categoria,
            @PathVariable("divisao") Divisao divisao){
        Categoria categ = categoriaServico.recuperaCategoriaPorDescricao(categoria);
        return timeService.recuperarTimesPorCategoriaEDivisao(categ, divisao);
    }

}
