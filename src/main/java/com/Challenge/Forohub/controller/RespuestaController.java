package com.Challenge.Forohub.controller;


import com.Challenge.Forohub.dto.RespuestaDTO;
import com.Challenge.Forohub.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<RespuestaDTO> getAllRespuestas() {
        return respuestaService.getAllRespuestas();
    }

    @PostMapping
    public RespuestaDTO createRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.createRespuesta(respuestaDTO);
    }
}
