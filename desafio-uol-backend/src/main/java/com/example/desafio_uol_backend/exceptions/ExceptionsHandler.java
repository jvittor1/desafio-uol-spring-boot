package com.example.desafio_uol_backend.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDTO> handleNoSuchElementException(NoSuchElementException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Não há codinomes disponiveis!", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> handleDuplicateException(DataIntegrityViolationException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Jogador já registrado!", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleException(Exception e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Houve um erro!", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
