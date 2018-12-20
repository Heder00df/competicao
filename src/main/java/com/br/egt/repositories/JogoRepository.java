package com.br.egt.repositories;

import com.br.egt.entidade.Jogo;
import com.br.egt.entidade.JogoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, JogoPK> {
}
