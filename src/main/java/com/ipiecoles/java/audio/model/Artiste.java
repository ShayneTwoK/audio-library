package com.ipiecoles.java.audio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artist")
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties("artist")

    private List<Album> desAlbums;

    public Artiste() {
    }

    public Artiste(Long id, String name, List<Album> desAlbums) {
        this.id = id;
        this.name = name;
        this.desAlbums = desAlbums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getDesAlbums() {
        return desAlbums;
    }
}
