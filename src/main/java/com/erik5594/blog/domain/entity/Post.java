package com.erik5594.blog.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:02
 */

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Link> links;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Imagem> imagems;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario criador;

    public Post() {
    }

    public Post(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Imagem> getImagems() {
        return imagems;
    }

    public void setImagems(List<Imagem> imagems) {
        this.imagems = imagems;
    }
}
