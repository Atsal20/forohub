package com.Challenge.Forohub.service;

import com.Challenge.Forohub.dto.PerfilDTO;
import com.Challenge.Forohub.model.Perfil;
import com.Challenge.Forohub.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDTO> getAllPerfiles() {
        return perfilRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PerfilDTO createPerfil(PerfilDTO perfilDTO) {
        Perfil perfil = new Perfil();
        perfil.setNombre(perfilDTO.getNombre());
        perfilRepository.save(perfil);
        return convertToDTO(perfil);
    }

    private PerfilDTO convertToDTO(Perfil perfil) {
        PerfilDTO perfilDTO = new PerfilDTO();
        perfilDTO.setId(perfil.getId());
        perfilDTO.setNombre(perfil.getNombre());
        return perfilDTO;
    }
}
