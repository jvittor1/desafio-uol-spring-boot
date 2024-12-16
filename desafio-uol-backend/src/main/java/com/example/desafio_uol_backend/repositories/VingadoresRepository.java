package com.example.desafio_uol_backend.repositories;

import com.example.desafio_uol_backend.dtos.VingadoresDTO;
import com.example.desafio_uol_backend.models.GrupoCodinome;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class VingadoresRepository implements CodinomeRepository {

    @Override
    public List<String> listarCodinomes(GrupoCodinome grupoCodinome) throws Exception {
        var codinomes = RestClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(grupoCodinome.getUrl())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var vingadores = new ObjectMapper().readValue(codinomes, VingadoresDTO.class);
        return vingadores.getCodinomes();
    }
}
