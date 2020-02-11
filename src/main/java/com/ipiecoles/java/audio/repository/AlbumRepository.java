package com.ipiecoles.java.audio.repository;

import com.ipiecoles.java.audio.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Optional<Album> findById(Long id);

    Album findByTitle(String title);

}
