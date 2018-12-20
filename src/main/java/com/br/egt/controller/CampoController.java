package com.br.egt.controller;

import com.br.egt.entidade.Campo;
import com.br.egt.service.CampoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/campo")
public class CampoController {

    @Autowired
    private CampoService service;

    @PostMapping("/incluir")
    public Campo salvar(Campo campo) {
        return service.salvar(campo);
    }
}