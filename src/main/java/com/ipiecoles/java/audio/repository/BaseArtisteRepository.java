package com.ipiecoles.java.audio.repository;

import com.ipiecoles.java.audio.model.Artiste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BaseArtisteRepository<T extends Artiste> extends PagingAndSortingRepository<T, Long> {

    Optional<T> findById(Long id);

    Page<T> findLesArtistesByName(String name, Pageable pageable);
}
