package com.example.desafio_uol_backend.dtos;

import java.util.List;

public record VingadoresDTO(List<Codinome> vingadores) implements CodinomeDTO {

    @Override
    public List<String> getCodinomes() {
        return vingadores.stream().map(Codinome::codinome).toList();
    }
}

record Codinome(String codinome) {
}