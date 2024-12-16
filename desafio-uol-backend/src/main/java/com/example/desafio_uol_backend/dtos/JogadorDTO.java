package com.example.desafio_uol_backend.dtos;

import com.example.desafio_uol_backend.models.GrupoCodinome;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JogadorDTO(@NotNull @NotBlank String nome,@NotNull @NotBlank @Email String email, String telefone, @NotNull GrupoCodinome grupoCodinome) {
}
