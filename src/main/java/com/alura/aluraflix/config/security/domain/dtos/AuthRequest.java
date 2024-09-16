package com.alura.aluraflix.config.security.domain.dtos;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;

}
