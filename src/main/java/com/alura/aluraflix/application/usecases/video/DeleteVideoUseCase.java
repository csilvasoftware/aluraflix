package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.repositories.VideoRepository;

public class DeleteVideoUseCase {

    private final VideoRepository videoRepository;

    public DeleteVideoUseCase(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public void execute(Long id) {
        if (!videoRepository.existsById(id)) {
            throw new RuntimeException("Video not found");
        }
        videoRepository.deleteById(id);
    }

}
