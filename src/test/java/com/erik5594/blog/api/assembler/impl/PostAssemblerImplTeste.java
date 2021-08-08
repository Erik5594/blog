package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.PostDto;
import com.erik5594.blog.domain.entity.Imagem;
import com.erik5594.blog.domain.entity.Link;
import com.erik5594.blog.domain.entity.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 10:36
 */
public class PostAssemblerImplTeste {

    private Assembler assembler;

    @Before
    public void before(){
        assembler = new PostAssemblerImpl();
    }

    @Test
    public void testePostDtoParaEntity(){
        //cenario
        PostDto postDto = new PostDto("Teste", "Conteudo teste");
        postDto.links = Arrays.asList("google.com","g1.com");
        postDto.imagensBase64 = Arrays.asList("dahgjkbhvwejh","fasdkhfçkldjasg", "akfnjdajbb");

        //acao
        Post post = (Post) assembler.dtoToEntity(postDto);

        //verificacao
        Assert.assertEquals(postDto.conteudo, post.getConteudo());
        Assert.assertEquals(postDto.titulo, post.getTitulo());
        Assert.assertEquals(postDto.links.size(), post.getLinks().size());
        Assert.assertEquals(postDto.imagensBase64.size(), post.getImagens().size());
        for(int x = 0; x < postDto.links.size(); x++){
            Assert.assertEquals(postDto.links.get(x), post.getLinks().get(x).getUrl());
        }
        for(int x = 0; x < postDto.imagensBase64.size(); x++){
            Assert.assertEquals(postDto.imagensBase64.get(x), post.getImagens().get(x).getImagemBase64());
        }
    }

    @Test
    public void testePostEntityParaDto(){
        //cenario
        Post post = new Post("Teste1", "Conteudo teste1");
        List<Imagem> imagens = Arrays.asList(new Imagem("djashfljkdah", post), new Imagem("fkjaslkdl", post));
        post.setImagens(imagens);

        List<Link> links = Arrays.asList(new Link("google.com", post), new Link("g1.com", post), new Link("facebook.com", post));
        post.setLinks(links);

        //acao
        PostDto postDto = (PostDto) assembler.entityToDto(post);

        //verificacao
        Assert.assertEquals(post.getTitulo(), postDto.titulo);
        Assert.assertEquals(post.getConteudo(), postDto.conteudo);
        Assert.assertEquals(post.getImagens().size(), postDto.imagensBase64.size());
        Assert.assertEquals(post.getLinks().size(), postDto.links.size());
        for(int x = 0; x < post.getImagens().size(); x++){
            Assert.assertEquals(post.getImagens().get(x).getImagemBase64(), postDto.imagensBase64.get(x));
        }

        for(int x = 0; x < post.getLinks().size(); x++){
            Assert.assertEquals(post.getLinks().get(x).getUrl(), postDto.links.get(x));
        }
    }

    @Test
    public void testePostDtoParaEntityLinksNullImagensNull(){
        //cenario
        PostDto postDto = new PostDto("Teste", "Conteudo teste");
        postDto.links = null;
        postDto.imagensBase64 = null;

        //acao
        Post post = (Post) assembler.dtoToEntity(postDto);

        //verificacao
        Assert.assertEquals(postDto.conteudo, post.getConteudo());
        Assert.assertEquals(postDto.titulo, post.getTitulo());
        Assert.assertEquals(0, post.getLinks().size());
        Assert.assertEquals(0, post.getImagens().size());
    }

    @Test
    public void testePostEntityParaDtoLinksNullImagensNull(){
        //cenario
        Post post = new Post("Teste1", "Conteudo teste1");
        post.setImagens(null);
        post.setLinks(null);

        //acao
        PostDto postDto = (PostDto) assembler.entityToDto(post);

        //verificacao
        Assert.assertEquals(post.getTitulo(), postDto.titulo);
        Assert.assertEquals(post.getConteudo(), postDto.conteudo);
        Assert.assertEquals(0, postDto.imagensBase64.size());
        Assert.assertEquals(0, postDto.links.size());
    }
}
