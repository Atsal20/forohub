package com.Challenge.Forohub.dto;

import com.Challenge.Forohub.model.Curso;
import com.Challenge.Forohub.model.Respuesta;
import lombok.Data;

@Data

public class RespuestaDTO extends Respuesta {

    private Long id;
    private String mensaje;
    private Long topicoId;
    private Long autorId;
}
