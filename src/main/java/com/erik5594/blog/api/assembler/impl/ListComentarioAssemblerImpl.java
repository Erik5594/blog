package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.ComentarioDto;
import com.erik5594.blog.api.dto.ComentarioResponseDto;
import com.erik5594.blog.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 16:30
 */
@Qualifier("comentarioList")
@Service
public class ListComentarioAssemblerImpl implements Assembler<List<ComentarioResponseDto>, List<Comentario>> {

    @Autowired
    private ComentarioAssemblerImpl assembler;

    @Override
    public List<Comentario> dtoToEntity(List<ComentarioResponseDto> dto) {
        if(dto != null) {
            return dto.stream().map(assembler::dtoToEntity).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ComentarioResponseDto> entityToDto(List<Comentario> entity) {
        if(entity != null){
            return entity.stream().map(assembler::entityToDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
