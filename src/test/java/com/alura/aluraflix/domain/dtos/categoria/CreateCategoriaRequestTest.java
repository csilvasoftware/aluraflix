package com.alura.aluraflix.domain.dtos.categoria;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CreateCategoriaRequestTest {

    private final Validator validator;

    public CreateCategoriaRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    public void testValidCreateCategoriaRequest() {
        CreateCategoriaRequest request = new CreateCategoriaRequest("Categoria1", "Blue");
        Set<ConstraintViolation<CreateCategoriaRequest>> violations = validator.validate(request);
        assertThat(violations).isEmpty();
    }

    @Test
    public void testInvalidCreateCategoriaRequest() {
        CreateCategoriaRequest request = new CreateCategoriaRequest("", " ");
        Set<jakarta.validation.ConstraintViolation<CreateCategoriaRequest>> violations = validator.validate(request);
        assertThat(violations).isNotEmpty();
        assertThat(violations).extracting("message").containsExactly(
                "O título de uma categoria não pode ser nulo.",
                "A cor de uma categoria não pode ser nula."
        );
    }

}