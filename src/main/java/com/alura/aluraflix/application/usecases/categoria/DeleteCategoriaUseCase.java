package com.alura.aluraflix.application.usecases.categoria;

import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public void execute(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada.");
        }
        categoriaRepository.deleteById(id);
    }

}
