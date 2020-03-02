package com.ipiecoles.java.audio.model;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name ="artistId", nullable = false)
    private Artiste artiste;

    public Album() {
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public Album(Long id, String title, Artiste artiste) {
        this.id = id;
        this.title = title;
        this.artiste = artiste;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

}