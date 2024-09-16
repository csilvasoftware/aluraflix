package com.alura.aluraflix.application.usecases.categoria;

import com.alura.aluraflix.domain.dtos.categoria.CreateCategoriaRequest;
import com.alura.aluraflix.domain.dtos.categoria.GetCategoriaResponse;
import com.alura.aluraflix.domain.entities.Categoria;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public GetCategoriaResponse execute(CreateCategoriaRequest dto) {
        Categoria categoria = new Categoria(dto.titulo(), dto.cor());
        categoriaRepository.save(categoria);
        return new GetCategoriaResponse(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }

}
