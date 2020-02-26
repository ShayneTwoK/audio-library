//package com.ipiecoles.java.audio.service;
//
//import com.ipiecoles.java.audio.model.Artiste;
//import com.ipiecoles.java.audio.repository.ArtisteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.Optional;
//
//@Service
//@Validated
//public class ArtisteService {
//
//    @Autowired
//    private ArtisteRepository artisteRepository;
//
//    public Artiste findById(Long id){
//        Optional<Artiste> artiste = artisteRepository.findById(id);
//
//        if(!artiste.isPresent()){
//            throw new EntityNotFoundException("L'employé d'identifiant " + id + " n'a pas été trouvé.");
//        }
//        return artiste.get();
//    }
//}
