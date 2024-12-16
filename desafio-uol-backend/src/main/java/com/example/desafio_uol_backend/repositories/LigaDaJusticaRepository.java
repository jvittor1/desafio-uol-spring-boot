package com.example.desafio_uol_backend.repositories;

import com.example.desafio_uol_backend.dtos.LigaDaJusticaDTO;
import com.example.desafio_uol_backend.models.GrupoCodinome;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository {
    public List<String> listarCodinomes(GrupoCodinome grupoCodinome) throws Exception {
        var codinomes = RestClient.builder()
                .baseUrl(grupoCodinome.getUrl())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var liga_da_justica = new XmlMapper().readValue(codinomes, LigaDaJusticaDTO.class);
        return liga_da_justica.getCodinomes();

    }
}
