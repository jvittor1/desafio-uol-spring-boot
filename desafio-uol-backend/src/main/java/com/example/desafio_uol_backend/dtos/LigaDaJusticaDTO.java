package com.example.desafio_uol_backend.dtos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record LigaDaJusticaDTO(
        @JacksonXmlProperty(localName = "codinomes")
        CodinomesDTO codinomes) implements CodinomeDTO {

    @Override
    public List<String> getCodinomes() {
        return codinomes.codinomes();
    }
}

record CodinomesDTO(
        @JacksonXmlProperty(localName = "codinome")
        @JacksonXmlElementWrapper(useWrapping = false)
        List<String> codinomes) {
}