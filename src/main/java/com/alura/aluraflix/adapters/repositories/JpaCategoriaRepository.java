package com.alura.aluraflix.adapters.repositories;

import com.alura.aluraflix.domain.entities.Categoria;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoriaRepository extends JpaRepository<Categoria, Long>, CategoriaRepository {
}
