package com.br.egt.service;

import com.br.egt.entidade.Usuario;
import com.br.egt.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private BCryptPasswordEncoder bp;

    @Autowired
    private UsuarioRepository repo;

    public Usuario salvarUsuario(Usuario usuario){
        usuario.setSenha(bp.encode(usuario.getSenha()));
        return repo.save(usuario);
    }
}
