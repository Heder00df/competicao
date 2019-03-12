package com.br.egt.service;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Endereco;
import com.br.egt.entidade.Telefone;
import com.br.egt.entidade.dtos.AtletaDto;
import com.br.egt.repositories.AtletaRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository rep;

    public AtletaDto salvar(AtletaDto dto) {
         //atleta.getTelefones().forEach( f-> f.setAtleta(atleta));

         Atleta atl = rep.findByCpf(dto.getCpf());

         if(atl != null){
             throw new IllegalArgumentException("Atleta já cadastrado");
         }
         atl = new Atleta();
         atl.setPosicao(dto.getPosicao());

         List<Telefone> telefones = Arrays
                 .asList(new Telefone(dto.getTelefoneCelular(), atl),
                         new Telefone(dto.getTelefoneFixo(), atl));


         atl.setTelefones(telefones);
         atl.setCpf(dto.getCpf());
         atl.setNome(dto.getNome());
         atl.setIdentidade(dto.getIdentidade());
         atl.setEndereco(new Endereco(dto.getLogradouro(), dto.getComplemento(), dto.getNumero()));
        return new AtletaDto(rep.save(atl));
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
