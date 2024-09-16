package com.alura.aluraflix.infrastructure.config;

import com.alura.aluraflix.adapters.repositories.JpaCategoriaRepository;
import com.alura.aluraflix.adapters.repositories.JpaVideoRepository;
import com.alura.aluraflix.application.usecases.video.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoUseCaseConfig {

    @Bean
    public CreateVideoUseCase createVideoUseCase(JpaVideoRepository videoRepository, JpaCategoriaRepository categoriaRepository) {
        return new CreateVideoUseCase(videoRepository, categoriaRepository);
    }

    @Bean
    public GetAllVideosUseCase getAllVideosUseCase(JpaVideoRepository videoRepository) {
        return new GetAllVideosUseCase(videoRepository);
    }

    @Bean
    public GetVideoByIdUseCase getVideoByIdUseCase(JpaVideoRepository videoRepository) {
        return new GetVideoByIdUseCase(videoRepository);
    }

    @Bean
    public GetTop5VideosOrderByIdDescUseCase getTop5VideosOrderByIdDescUseCase(JpaVideoRepository videoRepository) {
        return new GetTop5VideosOrderByIdDescUseCase(videoRepository);
    }

    @Bean
    public UpdateVideoUseCase updateVideoUseCase(JpaVideoRepository videoRepository) {
        return new UpdateVideoUseCase(videoRepository);
    }

    @Bean
    public DeleteVideoUseCase deleteVideoUseCase(JpaVideoRepository videoRepository) {
        return new DeleteVideoUseCase(videoRepository);
    }
}
