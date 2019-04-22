package com.br.egt.service;

import com.br.egt.entidade.Cliente;
import com.br.egt.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository rep;

    public Cliente recuperarClientePorId(Long codigo){
        return rep.findById(codigo).get();
    }


    public List<Cliente> recuperarClientes() {
        List<Cliente> Clientes = rep.findAll();
        return Clientes;
    }


}
