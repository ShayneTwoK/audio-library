//package com.ipiecoles.java.audio.service;
//
//
//import com.ipiecoles.java.audio.exception.ConflictException;
//import com.ipiecoles.java.audio.model.Artiste;
//import com.ipiecoles.java.audio.repository.ArtisteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.client.HttpClientErrorException;
//
//import javax.persistence.EntityNotFoundException;
//import javax.validation.Valid;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import java.lang.reflect.Field;
//import java.util.Arrays;
//
//@Service
//@Validated
//public class ArtisteService {
//
//    public static final int PAGE_SIZE_MIN = 10;
//    public static final int PAGE_SIZE_MAX = 100;
//    public static final int PAGE_MIN = 0;
//    private static final String PAGE_VALID_MESSAGE = "La taille de la page doit être comprise entre 10 et 100";
//
//    @Autowired
//    private ArtisteRepository artisteRepository;
//
//    public <T extends Artiste> T ajoutArtiste(@Valid T e) throws ConflictException {
//        if(artisteRepository.existsById(e.getId())) {
//            throw new ConflictException("L'artiste " + e.getId() + " existe déjà !");
//        }
//        return artisteRepository.save(e);
//    }
//
//    public Page<Artiste> findArtistesByName(
//            String name,
//            @Min(message = "Le numéro de page ne peut être inférieur à 0", value = PAGE_MIN)
//                    Integer page,
//            @Min(value = PAGE_SIZE_MIN, message = PAGE_VALID_MESSAGE)
//            @Max(value = PAGE_SIZE_MAX, message = PAGE_VALID_MESSAGE)
//                    Integer size,
//            String sortProperty,
//            Sort.Direction sortDirection
//    ) {
//        // Vérification de sortProperty
//        if (Arrays.stream(Artiste.class.getDeclaredFields()).
//                map(Field::getName).
//                filter(s -> s.equals(sortProperty)).count() != 1) {
//            throw new IllegalArgumentException("La propriété " + sortProperty + " n'existe pas !");
//        }
//
//        Pageable pageable = PageRequest.of(page,size,sortDirection, sortProperty);
//        Page<Artiste> lesArtistes = artisteRepository.findLesArtistesByName(name, pageable);
//        if (page >= lesArtistes.getTotalPages()) {
//            throw new IllegalArgumentException("Le numéro de page ne peut être supérieur à " + lesArtistes.getTotalPages());
//        } else if (lesArtistes.getTotalElements() == 0) {
//            throw new EntityNotFoundException("Il n'y a aucun employé dans la base de données");
//        }
//        return lesArtistes;
//    }
//}
