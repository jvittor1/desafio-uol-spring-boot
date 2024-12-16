package com.example.desafio_uol_backend.services;

import com.example.desafio_uol_backend.models.GrupoCodinome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CodinomeService {

    @Autowired
    private CodinomeFactoryService codinomeFactoryService;


    public String getCodinome(List<String> codinomes, GrupoCodinome grupoCodinome) throws Exception {
        var codinomesDisponiveis = getCodinomesDisponiveis(codinomes, grupoCodinome);

        if (codinomesDisponiveis.isEmpty()) {
            throw new NoSuchElementException();
        }
        return sorteiaCodinome(codinomesDisponiveis);
    }

    private String sorteiaCodinome(List<String> codinomesDisponiveis) {
        return codinomesDisponiveis.get((int)(Math.random() * codinomesDisponiveis.size()));
    }


    private List<String> getCodinomesDisponiveis(List<String> codinomes, GrupoCodinome grupoCodinome) throws Exception {
        var codinomesGrupo = getCodinomesGrupo(grupoCodinome);
        return codinomesGrupo.stream().filter(codinome -> !codinomes.contains(codinome)).toList();
    }

    private List<String> getCodinomesGrupo(GrupoCodinome grupoCodinome) throws Exception {
       var grupo = codinomeFactoryService.criarRepositorio(grupoCodinome);
       return grupo.listarCodinomes(grupoCodinome);
    }
}
