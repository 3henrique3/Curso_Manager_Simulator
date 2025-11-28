package com.henrique.curso.repository;

import com.henrique.curso.model.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, UUID> {
    Optional<DisciplinaModel> findById(UUID disciplinaId);

    boolean existsByTitulo(String titulo);
}
