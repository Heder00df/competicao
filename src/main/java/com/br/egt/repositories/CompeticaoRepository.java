package com.br.egt.repositories;

import com.br.egt.dtos.CompeticaoDto;
import com.br.egt.entidade.Competicao;
import com.br.egt.entidade.SituacaoCompeticao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {
    List<CompeticaoDto> findBySituacao(SituacaoCompeticao ativo);
}
