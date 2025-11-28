package com.henrique.curso.service;

import com.henrique.curso.dto.DisciplinaRecordDto;
import com.henrique.curso.model.DisciplinaModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DisciplinaService {
    List<DisciplinaModel> findAll();

    Optional<DisciplinaModel> findById(UUID disciplinaId);

    DisciplinaModel save(DisciplinaRecordDto disciplinaRecordDto);

    DisciplinaModel update(DisciplinaModel disciplinaModel, DisciplinaRecordDto disciplinaRecordDto);

    boolean existsByTitulo(String titulo);

    void delete(DisciplinaModel disciplinaModel);

    DisciplinaModel patchCategoria(DisciplinaModel disciplinaModel, DisciplinaRecordDto disciplinaRecordDto);
}
