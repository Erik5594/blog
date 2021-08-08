package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.dto.PostDto;
import com.erik5594.blog.domain.entity.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 10:16
 */
public class ListPostAssemblerImplTeste {
    private ListPostAssemblerImpl assembler;

    @Before
    public void before(){
        assembler = new ListPostAssemblerImpl();
        assembler.setAssembler(new PostAssemblerImpl());
    }

    @Test
    public void testeListPostDtoParaEntity(){
        //cenario
        List<PostDto> postsDto = Arrays.asList(new PostDto("Teste1", "Conteudo teste1"),
                new PostDto("Teste2", "Conteudo teste2"),
                new PostDto("Teste3", "Conteudo teste3"));


        //acao
        List<Post> posts = assembler.dtoToEntity(postsDto);

        //verificacao
        Assert.assertEquals(postsDto.size(), posts.size());
    }

    @Test
    public void testeListPostEntityParaDto(){
        //cenario
        List<Post> posts = Arrays.asList(new Post("Teste1", "Conteudo teste1"),
                new Post("Teste2", "Conteudo teste2"),
                new Post("Teste3", "Conteudo teste3"));


        //acao
        List<PostDto> postsDto = assembler.entityToDto(posts);

        //verificacao
        Assert.assertEquals(posts.size(), postsDto.size());
    }
}
