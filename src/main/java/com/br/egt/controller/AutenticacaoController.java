package com.br.egt.controller;

import com.br.egt.dtos.DadosAutenticacao;
import com.br.egt.dtos.TokenServico;
import com.br.egt.dtos.UsuarioAutenticado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoController {
    @PostMapping("/auth")
    public ResponseEntity<UsuarioAutenticado> autenticar(@RequestBody DadosAutenticacao dadosAutenticacao  )
    {

        TokenServico ts = new TokenServico("dfasdfadsfasdfasdfadsfadsf");
        UsuarioAutenticado usuarioAutenticado = new UsuarioAutenticado(ts);

        if(usuarioAutenticado == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(usuarioAutenticado, HttpStatus.OK);
    }


}
