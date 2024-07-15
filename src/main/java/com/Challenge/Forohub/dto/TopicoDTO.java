package com.Challenge.Forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class TopicoDTO {
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
    private String autor;

    @NotBlank
    private String curso;

    // Getters and Setters
}
