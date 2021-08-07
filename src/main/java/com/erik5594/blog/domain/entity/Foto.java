package com.erik5594.blog.domain.entity;

import javax.persistence.*;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:05
 */
@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fotoBase64;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Foto() {
    }

    public Foto(String fotoBase64, Album album) {
        this.fotoBase64 = fotoBase64;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
