package com.br.egt.controller;

import com.br.egt.entidade.Liga;
import com.br.egt.entidade.dtos.LigaDto;
import com.br.egt.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/liga")
public class LigaController {

    @Autowired
    private LigaService service;

    @PostMapping("/inserir")
    public Liga salvarLiga(@RequestBody Liga liga){
        return service.salvarLiga(liga);
    }

    @GetMapping("/id/{codigo}")
    public LigaDto recuperarLigaPorId(@PathVariable Long codigo){
        return new LigaDto(service.recuperarPorId(codigo));
    }
}
