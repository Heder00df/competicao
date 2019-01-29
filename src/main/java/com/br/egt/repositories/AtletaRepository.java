package com.br.egt.repositories;

import com.br.egt.entidade.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta,Long> {

    Atleta findByCpf(Long cpf);
}
