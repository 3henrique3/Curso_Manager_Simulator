package com.henrique.curso.dto;

import com.henrique.curso.enums.CategoriaDisciplina;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record DisciplinaRecordDto (
    UUID id,

    @NotBlank(message = "É necessário informar o título.")
    String titulo,

    @NotBlank(message = "É necessário informar a descrição da disciplina.")
    String descricao,

    @NotNull(message = "A categoria da disciplina é obrigatória.")
    CategoriaDisciplina categoriaDisciplina
){}
