package com.henrique.curso.service.impl;

import com.henrique.curso.dto.DisciplinaRecordDto;
import com.henrique.curso.model.DisciplinaModel;
import com.henrique.curso.repository.DisciplinaRepository;
import com.henrique.curso.service.DisciplinaService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    Logger logger = LogManager.getLogger(DisciplinaServiceImpl.class);

    final DisciplinaRepository disciplinaRepository;

    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public List<DisciplinaModel> findAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Optional<DisciplinaModel> findById(UUID disciplinaId) {
        Optional<DisciplinaModel> disciplinaOptional = disciplinaRepository.findById(disciplinaId);

        if (disciplinaOptional.isEmpty()) {
            logger.error("ERRO: Disciplina não encontrada.");
        }
        return disciplinaOptional;
    }

    @Transactional
    @Override
    public DisciplinaModel save(DisciplinaRecordDto disciplinaRecordDto) {
        var disciplinaModel = new DisciplinaModel();
        BeanUtils.copyProperties(disciplinaRecordDto, disciplinaModel);

        return disciplinaRepository.save(disciplinaModel);
    }

    @Transactional
    @Override
    public DisciplinaModel update(DisciplinaModel disciplinaModel, DisciplinaRecordDto disciplinaRecordDto) {
        disciplinaModel.setTitulo(disciplinaRecordDto.titulo());
        disciplinaModel.setDescricao(disciplinaRecordDto.descricao());
        disciplinaModel.setCategoriaDisciplina(disciplinaRecordDto.categoriaDisciplina());

        return disciplinaRepository.save(disciplinaModel);
    }

    @Transactional
    @Override
    public void delete(DisciplinaModel disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    @Override
    public boolean existsByTitulo(String titulo) {
        return disciplinaRepository.existsByTitulo(titulo);
    }

    @Override
    public DisciplinaModel patchCategoria(DisciplinaModel disciplinaModel, DisciplinaRecordDto disciplinaRecordDto) {
        disciplinaModel.setCategoriaDisciplina(disciplinaRecordDto.categoriaDisciplina());
        return disciplinaRepository.save(disciplinaModel);
    }
}
