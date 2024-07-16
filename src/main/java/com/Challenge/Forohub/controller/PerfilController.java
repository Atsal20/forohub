package com.Challenge.Forohub.controller;


import com.Challenge.Forohub.dto.PerfilDTO;
import com.Challenge.Forohub.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDTO> getAllPerfiles() {
        return perfilService.getAllPerfiles();
    }

    @PostMapping
    public PerfilDTO createPerfil(@RequestBody PerfilDTO perfilDTO) {
        return perfilService.createPerfil(perfilDTO);
    }
}
