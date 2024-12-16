package com.example.desafio_uol_backend.services;


import com.example.desafio_uol_backend.dtos.JogadorDTO;
import com.example.desafio_uol_backend.models.GrupoCodinome;
import com.example.desafio_uol_backend.models.Jogador;
import com.example.desafio_uol_backend.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private CodinomeService codinomeService;


    public Jogador createJogador(JogadorDTO jogador) throws Exception {
        // verifica codinomes disponiveis
        System.out.println("CHEGOU ISSO AKI: " + jogador);
        var codinomes = verificaCodinomes(jogador.grupoCodinome());
        // cria codinome
        var newCodinome = codinomeService.getCodinome(codinomes, jogador.grupoCodinome());
        // cria jogador
        Jogador newJogador = new Jogador(jogador.nome(), jogador.email(), jogador.telefone(), newCodinome, jogador.grupoCodinome());

        jogadorRepository.save(newJogador);
        return newJogador;

    }

    private List<String> verificaCodinomes(GrupoCodinome grupoCodinome) {
        return jogadorRepository.findCodinomesByGrupoCodinome(grupoCodinome);
    }


    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }
}
