package com.alura.aluraflix.domain.dtos.video;

import jakarta.validation.constraints.NotBlank;

public record UpdateVideoRequest(
        @NotBlank(message = "O título não pode ser nulo ou vazio") String titulo,
        @NotBlank(message = "A descrição não pode ser nula ou vazia") String descricao,
        @NotBlank(message = "A URL não pode ser nula ou vazia") String url
) {
}
