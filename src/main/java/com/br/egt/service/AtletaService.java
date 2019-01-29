package com.br.egt.service;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Telefone;
import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.repositories.AtletaRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository rep;

    public AtletaDto salvar(Atleta atleta) {
         atleta.getTelefones().forEach( f-> f.setAtleta(atleta));
        return new AtletaDto(rep.save(atleta));
    }

    public Atleta recuperaAteltaPorCpf(Long cpf){
        Atleta atl = rep.findByCpf(cpf);
        if(atl != null)
            return atl;
        return new Atleta();

    }

    public Atleta recuperarAtletaPorId(Long codigo){
        return rep.findById(codigo).get();
    }


    public List<Atleta> recuperarAtletas() {
        List<Atleta> atletas = rep.findAll();
        return atletas;
    }

    public void excluirAtleta(Atleta atleta) {
        rep.delete(atleta);
    }
}
