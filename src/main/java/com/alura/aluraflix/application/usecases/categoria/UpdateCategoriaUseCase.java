package com.alura.aluraflix.application.usecases.categoria;

import com.alura.aluraflix.domain.dtos.categoria.GetCategoriaResponse;
import com.alura.aluraflix.domain.dtos.categoria.UpdateCategoriaRequest;
import com.alura.aluraflix.domain.entities.Categoria;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public GetCategoriaResponse execute(Long id, UpdateCategoriaRequest dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));

        categoria.setTitulo(dto.titulo());
        categoria.setCor(dto.cor());
        categoriaRepository.save(categoria);
        return new GetCategoriaResponse(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }

}
