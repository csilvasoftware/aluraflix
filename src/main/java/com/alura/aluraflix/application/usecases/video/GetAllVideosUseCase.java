package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.entities.Video;
import com.alura.aluraflix.domain.repositories.VideoRepository;
import com.alura.aluraflix.domain.specifications.VideoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class GetAllVideosUseCase {

    private final VideoRepository videoRepository;

    public GetAllVideosUseCase(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Page<Video> execute(String title, int page, int size) {
        Specification<Video> spec = VideoSpecification.hasTitle(title);
        Pageable pageRequest = PageRequest.of(page, size);
        return videoRepository.findAll(spec, pageRequest);
    }

}
