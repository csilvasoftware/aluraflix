package com.alura.aluraflix.adapters.controllers;

import com.alura.aluraflix.application.usecases.categoria.*;
import com.alura.aluraflix.application.usecases.video.GetAllVideosPorCategoriaUseCase;
import com.alura.aluraflix.domain.dtos.categoria.CreateCategoriaRequest;
import com.alura.aluraflix.domain.dtos.categoria.GetCategoriaResponse;
import com.alura.aluraflix.domain.dtos.categoria.UpdateCategoriaRequest;
import com.alura.aluraflix.domain.dtos.video.GetVideoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private final GetAllCategoriasUseCase getAllCategoriasUseCase;
    private final GetCategoriaByIdUseCase getCategoriaByIdUseCase;
    private final CreateCategoriaUseCase createCategoriaUseCase;
    private final UpdateCategoriaUseCase updateCategoriaUseCase;
    private final DeleteCategoriaUseCase deleteCategoriaUseCase;
    private final GetAllVideosPorCategoriaUseCase getAllVideosPorCategoriaUseCase;

    @GetMapping
    public ResponseEntity<Page<GetCategoriaResponse>> getAllCategorias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<GetCategoriaResponse> categorias = getAllCategoriasUseCase.execute(page, size);
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Long id) {
        Optional<GetCategoriaResponse> categoriaOptional = getCategoriaByIdUseCase.execute(id);

        if (categoriaOptional.isPresent()) {
            return new ResponseEntity<>(categoriaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/videos")
    public ResponseEntity<List<GetVideoResponse>> getAllVideosPorCategoria(@PathVariable Long id) {
        List<GetVideoResponse> videosPorCategoria = getAllVideosPorCategoriaUseCase.execute(id);
        return new ResponseEntity<>(videosPorCategoria, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GetCategoriaResponse> create(@RequestBody @Valid CreateCategoriaRequest dto) {
        GetCategoriaResponse createdCategoria = createCategoriaUseCase.execute(dto);
        return new ResponseEntity<>(createdCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetCategoriaResponse> updateCategoria(@PathVariable Long id, @RequestBody @Valid UpdateCategoriaRequest dto) {
        GetCategoriaResponse updatedCategoria = updateCategoriaUseCase.execute(id, dto);
        return new ResponseEntity<>(updatedCategoria, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        deleteCategoriaUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
