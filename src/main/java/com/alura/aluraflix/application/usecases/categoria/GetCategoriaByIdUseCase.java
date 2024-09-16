package com.alura.aluraflix.application.usecases.categoria;

import com.alura.aluraflix.domain.dtos.categoria.GetCategoriaResponse;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GetCategoriaByIdUseCase {

    private final CategoriaRepository categoriaRepository;

    public Optional<GetCategoriaResponse> execute(Long id) {
        return categoriaRepository.findById(id).map(categoria -> new GetCategoriaResponse(categoria.getId(), categoria.getTitulo(), categoria.getCor()));
    }

}
