package com.br.egt.security;

import com.br.egt.entidade.Usuario;
import com.br.egt.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository rep;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = rep.findByEmail(email);

        if(usuario == null){
            throw new UsernameNotFoundException(email);
        }

        return new UserSpringSecurity(usuario.getId()
                ,usuario.getEmail()
                , usuario.getSenha()
                , usuario.getPerfis()
                , usuario.getCliente().getId());
    }
}
