package com.Challenge.Forohub.controller;


import com.Challenge.Forohub.dto.CursoDTO;
import com.Challenge.Forohub.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @PostMapping
    public CursoDTO createCurso(@RequestBody CursoDTO cursoDTO) {
        return cursoService.createCurso(cursoDTO);
    }
}
