package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.model.Artiste;
import com.ipiecoles.java.audio.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtisteController {

    @Autowired
    ArtisteRepository artisteRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Artiste> findById(@PathVariable (value = "id") Long id) {
        return artisteRepository.findById(id);
    }
}
