package com.alura.aluraflix.application.usecases.categoria;

import com.alura.aluraflix.domain.dtos.categoria.GetCategoriaResponse;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class GetAllCategoriasUseCase {

    private final CategoriaRepository repository;


    public GetAllCategoriasUseCase(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Page<GetCategoriaResponse> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable)
                .map(categoria -> new GetCategoriaResponse(categoria.getId(), categoria.getTitulo(), categoria.getCor()));
    }
}
