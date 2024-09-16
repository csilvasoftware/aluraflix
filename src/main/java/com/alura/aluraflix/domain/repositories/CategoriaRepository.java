package com.alura.aluraflix.domain.repositories;

import com.alura.aluraflix.domain.entities.Categoria;
import com.alura.aluraflix.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Categoria save(Categoria video);
    Optional<Categoria> findById(Long id);
    Page<Categoria> findAll(Pageable pageable);
    void deleteById(Long id);
    boolean existsById(Long id);
}
