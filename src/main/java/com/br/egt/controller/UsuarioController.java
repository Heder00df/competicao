package com.br.egt.controller;

import com.br.egt.entidade.Usuario;
import com.br.egt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/incluir")
    public Usuario salvarUsuario(Usuario usuario){
        return service.salvarUsuario(usuario);
    }
}
