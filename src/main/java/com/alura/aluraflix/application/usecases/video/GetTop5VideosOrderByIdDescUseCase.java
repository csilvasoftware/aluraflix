package com.alura.aluraflix.application.usecases.video;

import com.alura.aluraflix.domain.dtos.video.GetVideoResponse;
import com.alura.aluraflix.domain.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetTop5VideosOrderByIdDescUseCase {

    private final VideoRepository videoRepository;

    public List<GetVideoResponse> execute() {
        return videoRepository.findTop5ByOrderByIdDesc()
                .stream().map(video -> new GetVideoResponse(video.getId(), video.getCategoria().getId(), video.getTitulo(), video.getDescricao(), video.getUrl()))
                .toList();
    }

}
