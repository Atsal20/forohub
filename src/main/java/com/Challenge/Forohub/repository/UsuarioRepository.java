package com.Challenge.Forohub.repository;

import com.Challenge.Forohub.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}

