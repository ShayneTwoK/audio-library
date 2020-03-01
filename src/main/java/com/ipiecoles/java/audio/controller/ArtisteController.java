package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.exception.ConflictException;
import com.ipiecoles.java.audio.model.Artiste;
import com.ipiecoles.java.audio.repository.ArtisteRepository;
//import com.ipiecoles.java.audio.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtisteController {

    @Autowired
    ArtisteRepository artisteRepository;

//    @Autowired
//    private ArtisteService artisteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artiste findById(@PathVariable(value = "id") Long id) {
        // Exercice 1 retourner erreur 404 quand id artiste n'existe pas
        Optional<Artiste> artiste = artisteRepository.findById(id);
        if (!artiste.isPresent()) {
            throw new EntityNotFoundException("L'employé avec l'id &quot;" + id + "&quot; n'a pas été trouvé.");
        }
        return artiste.get();
    }

    @GetMapping(params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    // Exercice 2 parametres name et gestion de la pagination pour la recherche
    public Page<Artiste> findUnArtisteByName(
            @RequestParam("name") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        return artisteRepository.findLesArtistesByName(name, pageable);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // Exercice 3 affichage de tout les artistes et gestion de pagination
    public Page<Artiste> findLesArtistes(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortProperty", defaultValue = "name") String sortProperty,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") Sort.Direction sortDirection) {

        Pageable pageable = PageRequest.of(page, size, sortDirection, sortProperty);
        return artisteRepository.findAll(pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // Exercice 4 Ajouter un Artiste, retourner erreur 409 si l'artiste existe deja
    public Artiste ajoutArtiste(
            @RequestBody Artiste artiste) throws ConflictException {
        Artiste artisteAjouter = artisteRepository.findByName(artiste.getName());

        if (artisteAjouter != null){
            throw new ConflictException("L'artiste " + artiste.getId() + " existe déjà !");
        }
        return this.artisteRepository.save(artiste);
    }
}