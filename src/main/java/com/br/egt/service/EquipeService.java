package com.br.egt.service;

import com.br.egt.dtos.EquipeDTO;
import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Cliente;
import com.br.egt.entidade.Equipe;
import com.br.egt.entidade.Usuario;
import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.repositories.AtletaRepository;
import com.br.egt.repositories.EquipeRepository;
import com.br.egt.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository rep;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bp;

    public EquipeDTO salvar(EquipeDTO equipeDTO, Cliente cli) {

        Equipe equipe = new Equipe(equipeDTO.getDescricao(),equipeDTO.getId());

        Usuario usuario;

        if(equipeDTO.getId() != null){

            usuario =  usuarioRepository.findById(equipeDTO.getIdUsuario()).get();

            usuario.setEmail(equipeDTO.getEmail());

        }else{

            usuario = new Usuario(equipeDTO.getEmail(),cli, bp.encode("123456"));
        }

        usuarioRepository.save(usuario);

        equipe.setUsuario(usuario);

        rep.save(equipe);

        return converteEntidadeParaDto(equipe);
    }

    private EquipeDTO converteEntidadeParaDto(Equipe equipe) {
        return new EquipeDTO(equipe);
    }

    public List<EquipeDTO> recuperarEquipes() {
        List<Equipe> equipes = rep.findAll();

        return equipes.stream().map(e-> converteEntidadeParaDto(e)).collect(Collectors.toList());
    }

    public List<Equipe> equipes() {
        return rep.findAll();
    }

    public void excluir(Equipe equipe) {
        rep.delete(equipe);
    }
}