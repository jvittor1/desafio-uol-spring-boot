package com.example.desafio_uol_backend.repositories;

import com.example.desafio_uol_backend.models.GrupoCodinome;
import com.example.desafio_uol_backend.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    @Query("SELECT DISTINCT j.codinome FROM Jogador j WHERE j.grupo_codinome = :grupoCodinome")
    List<String> findCodinomesByGrupoCodinome(@Param("grupoCodinome") GrupoCodinome grupoCodinome);



}
