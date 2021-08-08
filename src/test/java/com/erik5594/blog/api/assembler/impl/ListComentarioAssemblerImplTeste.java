package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.dto.ComentarioResponseDto;
import com.erik5594.blog.domain.entity.Comentario;
import com.erik5594.blog.domain.entity.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 09:42
 */
public class ListComentarioAssemblerImplTeste {

    private ListComentarioAssemblerImpl assembler;

    @Before
    public void before(){
        assembler = new ListComentarioAssemblerImpl();
        assembler.setAssembler(new ComentarioAssemblerImpl());
    }

    @Test
    public void listComentarioDtoParaEntity(){
        //cenario
        List<ComentarioResponseDto> comentariosDto = Arrays.asList(
                new ComentarioResponseDto("teste1", 65132l),
                new ComentarioResponseDto("teste2", 6522l),
                new ComentarioResponseDto("teste3", 65187l));

        //acao
        List<Comentario> comentarios = assembler.dtoToEntity(comentariosDto);

        //verificacao
        Assert.assertEquals(comentariosDto.size(), comentarios.size());
    }

    @Test
    public void listComentarioEntityParaDto(){
        //cenario
        Comentario comentario1 = new Comentario("teste1");
        comentario1.setPost(new Post());
        Comentario comentario2 = new Comentario("teste2");
        comentario2.setPost(new Post());
        Comentario comentario3 = new Comentario("teste3");
        comentario3.setPost(new Post());

        List<Comentario> comentarios = Arrays.asList(comentario1,comentario2,comentario3);

        //acao
        List<ComentarioResponseDto> comentariosDto = assembler.entityToDto(comentarios);

        //verificacao
        Assert.assertEquals(comentarios.size(), comentariosDto.size());
    }

    @Test
    public void listComentarioDtoNull(){
        //cenario

        //acao
        List<Comentario> comentarios = assembler.dtoToEntity(null);

        //verificacao
        Assert.assertEquals(0, comentarios.size());
    }

    @Test
    public void listComentarioEntityNull(){
        //cenario

        //acao
        List<ComentarioResponseDto> comentariosDto = assembler.entityToDto(null);

        //verificacao
        Assert.assertEquals(0, comentariosDto.size());
    }
}
