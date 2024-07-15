package com.Challenge.Forohub.service;


import com.Challenge.Forohub.dto.TopicoDTO;
import com.Challenge.Forohub.repository.TopicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    private static final Logger logger = LoggerFactory.getLogger(TopicoService.class);

    @Autowired
    private TopicoRepository topicoRepository;

    public List<TopicoDTO> getAllTopics() {
        logger.info("Fetching all topics");
        return topicoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    public TopicoDTO getTopicById(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico not found"));
        return convertToDTO(topico);
    }

    public TopicoDTO createTopic(TopicoDTO topicoDTO) {
        Optional<Topico> existingTopico = topicoRepository.findByTituloAndMensaje(topicoDTO.getTitulo(), topicoDTO.getMensaje());
        if (existingTopico.isPresent()) {
            throw new RuntimeException("Topico already exists");
        }
        Topico topico = convertToEntity(topicoDTO);
        topico = topicoRepository.save(topico);
        return convertToDTO(topico);
    }

    public TopicoDTO updateTopic(Long id, TopicoDTO topicoDTO) {
        Topico existingTopico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico not found"));
        existingTopico.setTitulo(topicoDTO.getTitulo());
        existingTopico.setMensaje(topicoDTO.getMensaje());
        existingTopico.setStatus(topicoDTO.getStatus());
        existingTopico.setAutor(topicoDTO.getAutor());
        existingTopico = topicoRepository.save(existingTopico);
        return convertToDTO(existingTopico);
    }

    public void deleteTopic(Long id) {
        topicoRepository.deleteById(id);
    }

    private TopicoDTO convertToDTO(Topico topico) {
        TopicoDTO topicoDTO = new TopicoDTO();
        topicoDTO.setId(topico.getId());
        topicoDTO.setTitulo(topico.getTitulo());
        topicoDTO.setMensaje(topico.getMensaje());
        topicoDTO.setFechaCreacion(topico.getFechaCreacion());
        topicoDTO.setStatus(topico.getStatus());
        topicoDTO.setAutor(topico.getAutor());
        topicoDTO.setCurso(topico.getCurso().getNombre());
        return topicoDTO;
    }

    private Topico convertToEntity(TopicoDTO topicoDTO) {
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setStatus(topicoDTO.getStatus());
        topico.setAutor(topicoDTO.getAutor());
        return topico;
    }
}
