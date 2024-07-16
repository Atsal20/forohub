package com.Challenge.Forohub.service;

import com.Challenge.Forohub.dto.CursoDTO;
import com.Challenge.Forohub.model.Curso;
import com.Challenge.Forohub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> getAllCursos() {
        return cursoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CursoDTO createCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setCategoria(cursoDTO.getCategoria());
        cursoRepository.save(curso);
        return convertToDTO(curso);
    }

    private CursoDTO convertToDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setCategoria(curso.getCategoria());
        return cursoDTO;
    }
}

