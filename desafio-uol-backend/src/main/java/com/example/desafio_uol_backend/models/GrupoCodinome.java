package com.example.desafio_uol_backend.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GrupoCodinome {
    VINGADORES("Vingadores", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    LIGA_DA_JUSTICA("Liga da Justiça", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    private final String nome;
    private final String url;

    GrupoCodinome(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

}
