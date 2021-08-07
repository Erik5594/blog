package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.PostDto;
import com.erik5594.blog.domain.entity.Imagem;
import com.erik5594.blog.domain.entity.Link;
import com.erik5594.blog.domain.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:00
 */
@Qualifier("postList")
@Service
public class ListPostAssemblerImpl implements Assembler<List<PostDto>, List<Post>> {

    @Autowired
    private PostAssemblerImpl assembler;

    @Override
    public List<Post> dtoToEntity(List<PostDto> dto) {
        return dto.stream().map(assembler::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> entityToDto(List<Post> entity) {
        return entity.stream().map(assembler::entityToDto).collect(Collectors.toList());
    }
}
