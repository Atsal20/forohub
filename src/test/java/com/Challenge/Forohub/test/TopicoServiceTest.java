package com.Challenge.Forohub.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.Optional;

public class TopicoServiceTest {

    @Mock
    private TopicoRepository topicoRepository;

    @InjectMocks
    private TopicoService topicoService;

    public TopicoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTopicById() {
        Topico topico = new Topico();
        topico.setId(1L);
        topico.setTitulo("Titulo de prueba");
        topico.setMensaje("Mensaje de prueba");

        when(topicoRepository.findById(1L)).thenReturn(Optional.of(topico));

        TopicoDTO topicoDTO = topicoService.getTopicById(1L);

        assertEquals("Titulo de prueba", topicoDTO.getTitulo());
        assertEquals("Mensaje de prueba", topicoDTO.getMensaje());
    }

    // Otras pruebas
}

