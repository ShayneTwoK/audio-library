package com.ipiecoles.java.audio.controller;

import com.ipiecoles.java.audio.exception.ConflictException;
import com.ipiecoles.java.audio.model.Album;
import com.ipiecoles.java.audio.repository.AlbumRepository;
import com.ipiecoles.java.audio.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RequestMapping(value = "/albums")
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtisteRepository artisteRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // Exercice 7 Ajouter un Album
    public Album ajoutAlbum(
            @RequestBody Album album
    ) throws ConflictException {
        Album albumAjouter = albumRepository.findByTitle(album.getTitle());
        if (albumAjouter != null) {
            throw new ConflictException("l'album est déja présent dans la base de donées");
        }
        return albumRepository.save(album);
    }

    @DeleteMapping(value = "/{id}")
    // Exercice 8 Supprimer un Album existant
    public void supprimerUnAlbum(
            @PathVariable("id") Long id) {
        albumRepository.deleteById(id);
    }
}
