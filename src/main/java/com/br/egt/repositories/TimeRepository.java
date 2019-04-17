package com.br.egt.repositories;

import com.br.egt.entidade.Time;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    @Query("SELECT t FROM Time t WHERE t.competicao.id= :codigo")
    List<Time> recuperarTimesPorCompeticao(@Param("codigo") Long codigo);

}
