package com.alura.aluraflix.domain.specifications;

import com.alura.aluraflix.domain.entities.Video;
import org.springframework.data.jpa.domain.Specification;

public class VideoSpecification {

    public static Specification<Video> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> {
            if (title == null || title.isEmpty()) {
                return criteriaBuilder.conjunction(); // Retorna todas as entradas se o título não for especificado
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("titulo")), "%" + title.toLowerCase() + "%");
        };
    }

}
