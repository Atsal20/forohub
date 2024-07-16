package com.Challenge.Forohub.service;

import com.Challenge.Forohub.dto.RespuestaDTO;
import com.Challenge.Forohub.model.Respuesta;
import com.Challenge.Forohub.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public List<RespuestaDTO> getAllRespuestas() {
        return respuestaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RespuestaDTO createRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(respuestaDTO.getMensaje());
        // You can set other properties of Respuesta here
        respuestaRepository.save(respuesta);
        return convertToDTO(respuesta);
    }

    private RespuestaDTO convertToDTO(Respuesta respuesta) {
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setId(respuesta.getId());
        respuestaDTO.setMensaje(respuesta.getMensaje());
        // You can set other properties of RespuestaDTO here
        return respuestaDTO;
    }
}
