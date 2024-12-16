package com.example.desafio_uol_backend.repositories;

import com.example.desafio_uol_backend.models.GrupoCodinome;

import java.util.List;

public interface CodinomeRepository {
    public List<String> listarCodinomes(GrupoCodinome grupoCodinome) throws Exception;
}
