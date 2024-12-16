package com.example.desafio_uol_backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "JOGADORES")

public class Jogador
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    private String telefone;
    @NotNull
    private String codinome;
    @NotNull
    @Column(name = "grupo_codinome")
    @Enumerated(EnumType.STRING)
    private GrupoCodinome grupo_codinome;


    public Jogador() {}

    public Jogador(Long id, String nome, String email, String telefone, String codinome, GrupoCodinome grupo_codinome)
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.codinome = codinome;
        this.grupo_codinome = grupo_codinome;
    }


    public Jogador(String nome, String email, String telefone, String codinome, GrupoCodinome grupo_codinome)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.codinome = codinome;
        this.grupo_codinome = grupo_codinome;
    }



    public Long getId() {
        return id;
    }

    public @NotNull String getNome() {
        return nome;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public @NotNull String getCodinome() {
        return codinome;
    }

    public @NotNull GrupoCodinome getGrupo_codinome() {
        return grupo_codinome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(@NotNull String nome) {
        this.nome = nome;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCodinome(@NotNull String codinome) {
        this.codinome = codinome;
    }

    public void setGrupo_codinome(@NotNull GrupoCodinome grupo_codinome) {
        this.grupo_codinome = grupo_codinome;
    }

}
