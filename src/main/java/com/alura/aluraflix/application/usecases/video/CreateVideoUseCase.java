package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.entities.Categoria;
import com.alura.aluraflix.domain.entities.Video;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import com.alura.aluraflix.domain.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class CreateVideoUseCase {

    private final VideoRepository videoRepository;
    private final CategoriaRepository categoriaRepository;


    public Video execute(String titulo, String descricao, String url, Long categoriaId) {

        Categoria categoria;

        if (nonNull(categoriaId)) {
            Optional<Categoria> optionalCategoria = categoriaRepository.findById(categoriaId);
            categoria = optionalCategoria.orElseGet(() -> categoriaRepository.findById(1L).get());
        } else {
            categoria = categoriaRepository.findById(1L).get();
        }


        Video video = new Video(titulo, descricao, url, categoria);
        return videoRepository.save(video);
    }

}
