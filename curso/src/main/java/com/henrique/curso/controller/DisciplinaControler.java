package com.henrique.curso.controller;

import com.henrique.curso.dto.DisciplinaRecordDto;
import com.henrique.curso.model.DisciplinaModel;
import com.henrique.curso.service.DisciplinaService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    Logger logger = LogManager.getLogger(DisciplinaController.class);

    final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDisciplina(@RequestBody DisciplinaRecordDto disciplinaRecordDto) {
        if (disciplinaService.existsByTitulo(disciplinaRecordDto.titulo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse título já está em uso por outra disciplina.");
        }

        logger.debug("POST: saveDisciplina, dados recebidos: {}", disciplinaRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.save(disciplinaRecordDto));
    }

    @GetMapping
    public ResponseEntity<List <DisciplinaModel>> todasDisciplinas() {
        List<DisciplinaModel> listaDisciplinas = disciplinaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaDisciplinas);
    }

    @GetMapping("/disciplinaId/{disciplinaId}")
    public ResponseEntity<Object> retornaUmaDisciplina(@PathVariable(value = "disciplinaId") UUID disciplinaId) {
        logger.debug("GET: getOneLivro, consulta: {}", disciplinaId);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findById(disciplinaId));
    }

    @PutMapping("/{disciplinaId}")
    public ResponseEntity<Object> updateDisciplina(@PathVariable(value = "disciplinaId") UUID disciplinaId, @RequestBody DisciplinaRecordDto disciplinaRecordDto) {
        logger.debug("PUT: updateDisciplina, disciplinaId recebido: {}", disciplinaId);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.update(disciplinaService.findById(disciplinaId).get(), disciplinaRecordDto));
    }

    @PatchMapping("/{disciplinaId}")
    public ResponseEntity<Object> patchCategoriaDisciplina(@PathVariable(value = "disciplinaId") UUID disciplinaId, @RequestBody DisciplinaRecordDto disciplinaRecordDto) {
        logger.debug("PATCH: patchCategoriaDisciplina, disciplinaId recebido: {}", disciplinaId);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.patchCategoria(disciplinaService.findById(disciplinaId).get(), disciplinaRecordDto));
    }

    @DeleteMapping("/{disciplinaId}")
    public ResponseEntity<Object> deleteDisciplina(@PathVariable(value = "disciplinaId") UUID disciplinaId) {
        Optional<DisciplinaModel> acharIdDisciplina = disciplinaService.findById(disciplinaId);
        DisciplinaModel disciplina = acharIdDisciplina.get();

        disciplinaService.delete(disciplinaService.findById(disciplinaId).get());
        logger.debug("DELETE: deleteDisciplina, disciplinaId recebido: {}", disciplinaId);
        return ResponseEntity.noContent().build();
    }
}
