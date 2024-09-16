package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.entities.Video;
import com.alura.aluraflix.domain.repositories.VideoRepository;

public class UpdateVideoUseCase {

    private final VideoRepository videoRepository;

    public UpdateVideoUseCase(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video execute(Long id, String titulo, String descricao, String url) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        video.setTitulo(titulo);
        video.setDescricao(descricao);
        video.setUrl(url);

        return videoRepository.save(video);
    }

}
