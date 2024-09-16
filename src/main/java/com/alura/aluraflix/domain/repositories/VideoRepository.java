package com.alura.aluraflix.domain.repositories;

import com.alura.aluraflix.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {
    Video save(Video video);
    Optional<Video> findById(Long id);
    Page<Video> findAll(Specification<Video> spec, Pageable pageRequest);
    void deleteById(Long id);
    boolean existsById(Long id);

    List<Video> findAllByCategoriaId(Long categoriaId);

    List<Video> findTop5ByOrderByIdDesc();
}
