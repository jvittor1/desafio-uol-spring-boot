package com.example.desafio_uol_backend.controllers;

import com.example.desafio_uol_backend.dtos.JogadorDTO;
import com.example.desafio_uol_backend.models.Jogador;
import com.example.desafio_uol_backend.services.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping("/create")
    public ResponseEntity<Jogador> createJogador(@RequestBody @Valid JogadorDTO jogador) throws Exception {
        var newJogador = jogadorService.createJogador(jogador);
        return ResponseEntity.created(null).body(newJogador);
    }


    @GetMapping("/")
    public ResponseEntity<List<Jogador>> listarJogadores() {
        return ResponseEntity.ok(jogadorService.listarJogadores());
    }

}
