package com.erik5594.blog.domain.entity;

import javax.persistence.*;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:07
 */
@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Link() {
    }

    public Link(String url, Post post) {
        this.url = url;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
