package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.ComentarioDto;
import com.erik5594.blog.api.dto.ComentarioResponseDto;
import com.erik5594.blog.api.dto.PostDto;
import com.erik5594.blog.domain.entity.Comentario;
import com.erik5594.blog.domain.entity.Imagem;
import com.erik5594.blog.domain.entity.Link;
import com.erik5594.blog.domain.entity.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:00
 */
@Qualifier("comentario")
@Service
public class ComentarioAssemblerImpl implements Assembler<ComentarioResponseDto, Comentario> {

    @Override
    public Comentario dtoToEntity(ComentarioResponseDto dto) {
        Comentario comentario = new Comentario(dto.conteudo);
        Post post = new Post();
        post.setId(dto.idPost);
        comentario.setPost(post);
        return comentario;
    }

    @Override
    public ComentarioResponseDto entityToDto(Comentario entity) {
        ComentarioResponseDto comentarioDto = new ComentarioResponseDto();
        comentarioDto.conteudo = entity.getComentario();
        comentarioDto.idPost = entity.getPost().getId();
        comentarioDto.data = entity.getData();
        return comentarioDto;
    }
}
