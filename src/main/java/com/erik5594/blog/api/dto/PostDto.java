package com.erik5594.blog.api.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 02/08/2021 - 19:00
 */
public class PostDto {

    public String titulo;
    public String conteudo;
    public List<String> links;
    public List<String> imagensBase64;

    public PostDto() {
        this.links = new ArrayList<>();
        this.imagensBase64 = new ArrayList<>();
    }

    public PostDto(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.links = new ArrayList<>();
        this.imagensBase64 = new ArrayList<>();
    }
}
