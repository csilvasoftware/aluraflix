package com.alura.aluraflix.domain.dtos.video;

public record GetVideoResponse(Long id, Long categoriaId, String titulo, String descricao, String url) {
}
