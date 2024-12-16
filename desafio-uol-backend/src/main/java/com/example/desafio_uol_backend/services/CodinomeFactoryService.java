package com.example.desafio_uol_backend.services;

import com.example.desafio_uol_backend.models.GrupoCodinome;
import com.example.desafio_uol_backend.repositories.CodinomeRepository;
import com.example.desafio_uol_backend.repositories.LigaDaJusticaRepository;
import com.example.desafio_uol_backend.repositories.VingadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodinomeFactoryService {

    @Autowired
    private VingadoresRepository vingadoresRepository;

    @Autowired
    private LigaDaJusticaRepository ligaDaJusticaRepository;


    public CodinomeRepository criarRepositorio(GrupoCodinome grupoCodinome) {
        if (grupoCodinome.equals(GrupoCodinome.VINGADORES)) {
            return vingadoresRepository;
        } else if (grupoCodinome.equals(GrupoCodinome.LIGA_DA_JUSTICA)) {
            return ligaDaJusticaRepository;
        }
        return null;
    }

}
