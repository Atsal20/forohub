package com.Challenge.Forohub.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String categoria;
}

