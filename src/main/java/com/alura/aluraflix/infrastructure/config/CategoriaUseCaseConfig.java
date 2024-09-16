package com.alura.aluraflix.infrastructure.config;

import com.alura.aluraflix.adapters.repositories.JpaCategoriaRepository;
import com.alura.aluraflix.adapters.repositories.JpaVideoRepository;
import com.alura.aluraflix.application.usecases.categoria.*;
import com.alura.aluraflix.application.usecases.video.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaUseCaseConfig {

    @Bean
    public GetAllCategoriasUseCase getAllCategoriasUseCase(JpaCategoriaRepository categoriaRepository) {
        return new GetAllCategoriasUseCase(categoriaRepository);
    }

    @Bean
    public GetCategoriaByIdUseCase getCategoriaByIdUseCase(JpaCategoriaRepository categoriaRepository) {
        return new GetCategoriaByIdUseCase(categoriaRepository);
    }

    @Bean
    public CreateCategoriaUseCase createCategoriaUseCase(JpaCategoriaRepository categoriaRepository) {
        return new CreateCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public UpdateCategoriaUseCase updateCategoriaUseCase(JpaCategoriaRepository categoriaRepository) {
        return new UpdateCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public DeleteCategoriaUseCase deleteCategoriaUseCase(JpaCategoriaRepository categoriaRepository) {
        return new DeleteCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public GetAllVideosPorCategoriaUseCase getAllVideosPorCategoriaUseCase(JpaCategoriaRepository categoriaRepository, JpaVideoRepository videoRepository) {
        return new GetAllVideosPorCategoriaUseCase(categoriaRepository, videoRepository);
    }
}
