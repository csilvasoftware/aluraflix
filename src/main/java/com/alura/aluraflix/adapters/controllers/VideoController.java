package com.alura.aluraflix.adapters.controllers;

import com.alura.aluraflix.application.usecases.video.*;
import com.alura.aluraflix.domain.dtos.video.CreateVideoRequest;
import com.alura.aluraflix.domain.dtos.video.GetVideoResponse;
import com.alura.aluraflix.domain.dtos.video.UpdateVideoRequest;
import com.alura.aluraflix.domain.entities.Video;
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
@RequestMapping("/videos")
public class VideoController {

    private final CreateVideoUseCase createVideoUseCase;
    private final GetAllVideosUseCase getAllVideosUseCase;
    private final GetVideoByIdUseCase getVideoByIdUseCase;
    private final UpdateVideoUseCase updateVideoUseCase;
    private final DeleteVideoUseCase deleteVideoUseCase;
    private final GetTop5VideosOrderByIdDescUseCase getTop5VideosOrderByIdDescUseCase;

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody @Valid CreateVideoRequest dto) {
        Video createdVideo = createVideoUseCase.execute(dto.titulo(), dto.descricao(), dto.url(), dto.categoriaId());
        return new ResponseEntity<>(createdVideo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Video>> getAllVideos(
            @RequestParam(required = false, name = "search") String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<Video> videos = getAllVideosUseCase.execute(title, page, size);
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVideoById(@PathVariable Long id) {
        Optional<Video> videoOptional = getVideoByIdUseCase.execute(id);

        if (videoOptional.isPresent()) {
            return new ResponseEntity<>(videoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Vídeo não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/free")
    public ResponseEntity<List<GetVideoResponse>> getTop5VideosOrderByIdDesc() {
        List<GetVideoResponse> videos = getTop5VideosOrderByIdDescUseCase.execute();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody @Valid UpdateVideoRequest dto) {
        Video updatedVideo = updateVideoUseCase.execute(id, dto.titulo(), dto.descricao(), dto.url());
        return new ResponseEntity<>(updatedVideo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        deleteVideoUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
