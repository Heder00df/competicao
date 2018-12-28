package com.br.egt.repositories;

import com.br.egt.entidade.Jogo;
import com.br.egt.entidade.JogoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, JogoPK> {

    @Query("SELECT jg FROM Jogo jg WHERE jg.rodada=(:rodada)")
    List<Jogo>  recuperaJogosPorRodada(@Param("rodada") Integer rodada);


    }

