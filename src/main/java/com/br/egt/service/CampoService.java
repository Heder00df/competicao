package com.br.egt.service;

import com.br.egt.entidade.Campo;
import com.br.egt.repositories.CampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampoService {

    @Autowired
    private CampoRepository rep;

    public Campo salvar(Campo campo) {
        return rep.save(campo);

    }
}
