package com.alura.aluraflix.domain.dtos.categoria;

import jakarta.validation.constraints.NotBlank;

public record UpdateCategoriaRequest(
        @NotBlank(message = "O título de uma categoria não pode ser nulo.") String titulo,
        @NotBlank(message = "A cor de uma categoria não pode ser nula.") String cor
) {
}
