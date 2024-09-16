package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.dtos.video.GetVideoResponse;
import com.alura.aluraflix.domain.entities.Categoria;
import com.alura.aluraflix.domain.repositories.CategoriaRepository;
import com.alura.aluraflix.domain.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllVideosPorCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;
    private final VideoRepository videoRepository;

    public List<GetVideoResponse> execute(Long categoriaId) {
        Categoria categoria = categoriaRepository
                .findById(categoriaId).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return videoRepository.findAllByCategoriaId(categoriaId)
                .stream().map(video -> new GetVideoResponse(video.getId(), categoria.getId(), video.getTitulo(), video.getDescricao(), video.getUrl()))
                .toList();
    }

}
