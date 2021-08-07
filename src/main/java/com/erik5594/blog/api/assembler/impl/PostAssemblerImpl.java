package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.PostDto;
import com.erik5594.blog.api.dto.UsuarioDto;
import com.erik5594.blog.domain.entity.Imagem;
import com.erik5594.blog.domain.entity.Link;
import com.erik5594.blog.domain.entity.Post;
import com.erik5594.blog.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:00
 */
@Qualifier("post")
@Service
public class PostAssemblerImpl implements Assembler<PostDto, Post> {

    @Override
    public Post dtoToEntity(PostDto dto) {
        Post post = new Post(dto.titulo, dto.conteudo);
        post.setImagems(getListImagens(dto.imagensBase64, post));
        post.setLinks(getListLinks(dto.links, post));
        return post;
    }

    @Override
    public PostDto entityToDto(Post entity) {
        PostDto postDto = new PostDto(entity.getTitulo(), entity.getConteudo());
        postDto.links = getListLinksDto(entity.getLinks());
        postDto.imagensBase64 = getListImagensDto(entity.getImagems());
        return postDto;
    }

    private List<String> getListLinksDto(List<Link> links){
        return links.stream().map(Link::getUrl).collect(Collectors.toList());
    }

    private List<String> getListImagensDto(List<Imagem> imagems){
        return imagems.stream().map(Imagem::getImagemBase64).collect(Collectors.toList());
    }

    private List<Imagem> getListImagens(List<String> imagensDto, Post post){
        List<Imagem> imagens = new ArrayList<>();
        if(imagensDto != null){
            for(String imagemDto : imagensDto){
                imagens.add(new Imagem(imagemDto, post));
            }
        }
        return imagens;
    }

    private List<Link> getListLinks(List<String> linksDto, Post post){
        List<Link> links = new ArrayList<>();
        if(linksDto != null) {
            for (String url : linksDto) {
                links.add(new Link(url, post));
            }
        }
        return links;
    }
}
