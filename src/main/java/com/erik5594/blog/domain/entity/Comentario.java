package com.erik5594.blog.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 10:34
 */
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private Date data;
    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario autor;
    @JoinColumn(name = "post_id")
    @ManyToOne
    private Post post;

    public Comentario() {
    }

    public Comentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
