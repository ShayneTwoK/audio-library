package com.ipiecoles.java.audio.repository;

import com.ipiecoles.java.audio.model.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtisteRepository extends JpaRepository<Artiste, Long> {

    Optional<Artiste> findById(Long id);

    Artiste findByName(String name);
}
