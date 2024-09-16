package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.entities.Video;
import com.alura.aluraflix.domain.repositories.VideoRepository;

import java.util.Optional;

public class GetVideoByIdUseCase {

    private final VideoRepository videoRepository;

    public GetVideoByIdUseCase(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Optional<Video> execute(Long id) {
        return videoRepository.findById(id);
    }

}
