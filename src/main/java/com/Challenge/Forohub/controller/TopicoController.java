package com.Challenge.Forohub.controller;


import com.Challenge.Forohub.dto.TopicoDTO;
import com.Challenge.Forohub.service.TopicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@Api(value = "Topico Management System", description = "Operations pertaining to topic in the ForumHub")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    @ApiOperation(value = "View a list of available topics", response = List.class)
    public List<TopicoDTO> getAllTopics() {
        return topicoService.getAllTopics();
    }

    @GetMapping("/{id}")
    public TopicoDTO getTopicById(@PathVariable Long id) {
        return topicoService.getTopicById(id);
    }

    @PostMapping
    public TopicoDTO createTopic(@RequestBody @Valid TopicoDTO topicoDTO) {
        return topicoService.createTopic(topicoDTO);
    }

    @PutMapping("/{id}")
    public TopicoDTO updateTopic(@PathVariable Long id, @RequestBody @Valid TopicoDTO topicoDTO) {
        return topicoService.updateTopic(id, topicoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicoService.deleteTopic(id);
    }
}
