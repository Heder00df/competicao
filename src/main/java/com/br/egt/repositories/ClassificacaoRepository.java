package com.br.egt.repositories;

import com.br.egt.dtos.ClassificacaoDto;
import com.br.egt.entidade.Classificacao;
import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.SituacaoCompeticao;
import com.br.egt.entidade.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {
    Classificacao findByTimeAndCompeticao(Time time, Competicao competicao);

    @Query("select c from Classificacao c where c.competicao.situacao = :situacao")
    List<Classificacao> classificacoesPorSituacaoCompeticao(@Param("situacao") SituacaoCompeticao situacao);
}
