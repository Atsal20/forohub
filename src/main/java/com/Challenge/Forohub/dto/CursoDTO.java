package com.Challenge.Forohub.dto;

import com.Challenge.Forohub.model.Curso;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

public class CursoDTO extends Curso {

    private Long id;
    private String nombre;
    private String categoria;

}
