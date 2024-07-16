package com.Challenge.Forohub.dto;

import com.Challenge.Forohub.model.Curso;
import com.Challenge.Forohub.model.Topico;
import com.Challenge.Forohub.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TopicoDTO extends Topico {
    private Long id;

    @NotBlank(message = "El título no puede estar en blanco")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar en blanco")
    private String mensaje;

    private LocalDateTime fechaCreacion;

    @NotBlank
    private String status;

    @NotBlank
    private Usuario autor;

    @NotBlank
    private Curso curso;

}
