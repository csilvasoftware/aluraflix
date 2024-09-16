package com.alura.aluraflix.config.security.domain.repositories;

import com.alura.aluraflix.config.security.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

}
