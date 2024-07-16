package com.Challenge.Forohub.dto;

import com.Challenge.Forohub.model.Curso;
import com.Challenge.Forohub.model.Perfil;
import lombok.Data;

@Data

public class PerfilDTO extends Perfil {

    private Long id;
    private String nombre;

}
