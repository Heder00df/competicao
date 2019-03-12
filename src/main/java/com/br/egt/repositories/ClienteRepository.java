package com.br.egt.repositories;

import com.br.egt.entidade.Atleta;
import com.br.egt.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
