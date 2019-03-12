package com.br.egt.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable()
    private Set<Integer> perfils;

    public Usuario(){}

    public Usuario(String email, Cliente cli, String senha) {
        this.email = email;
        this.cliente = cli;
        this.senha=senha;
    }

    public Set<Perfil> getPerfis(){
        return perfils.stream().map(p-> Perfil.toEnum(p)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil){
        perfils.add(perfil.getCodigo());
    }



}
