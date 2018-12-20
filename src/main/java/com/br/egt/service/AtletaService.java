package com.br.egt.service;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Telefone;
import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository rep;

    public AtletaDto salvar(Atleta atleta) {
         atleta.getTelefones().forEach( f-> f.setAtleta(atleta));
        return new AtletaDto(rep.save(atleta));
    }

    public List<Atleta> recuperarAtletas() {
        return rep.findAll();
    }
}
