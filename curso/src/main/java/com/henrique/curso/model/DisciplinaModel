package com.henrique.curso.model;

import com.henrique.curso.enums.CategoriaDisciplina;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "disciplina")
public class DisciplinaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoriaDisciplina", nullable = false)
    private CategoriaDisciplina categoriaDisciplina;
}
