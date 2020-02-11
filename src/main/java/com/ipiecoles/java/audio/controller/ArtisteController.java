package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.model.Artiste;
import com.ipiecoles.java.audio.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtisteController {

    @Autowired
    ArtisteRepository artisteRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artiste findById(@PathVariable (value = "id") Long id) {
        return artisteRepository.findById(id).get();
    }
}
