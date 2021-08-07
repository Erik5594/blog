package com.erik5594.blog.domain.entity;

import javax.persistence.*;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:05
 */
@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagemBase64;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Imagem() {
    }

    public Imagem(String imagemBase64, Post post) {
        this.imagemBase64 = imagemBase64;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
