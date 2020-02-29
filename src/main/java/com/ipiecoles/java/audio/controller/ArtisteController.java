package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.model.Artiste;
import com.ipiecoles.java.audio.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtisteController {

    @Autowired
    ArtisteRepository artisteRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artiste findById(@PathVariable(value = "id") Long id) {
        // Exercice 1 retourner erreur 404 quand id artiste n'exisite pas
        Optional<Artiste> artiste = artisteRepository.findById(id);
        if (!artiste.isPresent()) {
            throw new EntityNotFoundException("L'employé avec l'id &quot;" + id + "&quot; n'a pas été trouvé.");
        }
        return artiste.get();
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, params = "name")
    public Page<Artiste> findLesArtistesByName(
            @RequestParam("name" ) String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam("sortDirection") Sort.Direction sortDirection,
            @RequestParam("sortProperty") String sortProperty) {

        Pageable pageable = PageRequest.of(page,size, sortDirection,sortProperty);
        return artisteRepository.findLesArtistesByName(name, pageable);
    }

}
