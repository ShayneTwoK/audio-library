package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.model.Artiste;
import com.ipiecoles.java.audio.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtisteController {

    @Autowired
    ArtisteRepository artisteRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artiste findById(@PathVariable (value = "id") Long id) {
        Optional<Artiste> artiste = artisteRepository.findById(id);
        if(!artiste.isPresent()){
            throw new EntityNotFoundException("L'employé avec l'id &quot;" + id + "&quot; n'a pas été trouvé.");
        }
        return artiste.get();
    }
}
