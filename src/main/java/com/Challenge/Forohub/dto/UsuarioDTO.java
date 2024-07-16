package com.Challenge.Forohub.dto;

import com.Challenge.Forohub.model.Curso;
import com.Challenge.Forohub.model.Usuario;
import lombok.Data;

@Data

public class UsuarioDTO extends Usuario {
    private Long id;
    private String username;
    private String password;
    private String email;
}
