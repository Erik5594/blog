package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.AlbumDto;
import com.erik5594.blog.api.dto.PostDto;
import com.erik5594.blog.domain.entity.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:00
 */
@Qualifier("album")
@Service
public class AlbumAssemblerImpl implements Assembler<AlbumDto, Album> {

    @Override
    public Album dtoToEntity(AlbumDto dto) {
        Album album = new Album(dto.titulo, dto.descricao);
        album.setFotos(getListFotos(dto.fotosBase64, album));
        return album;
    }

    @Override
    public AlbumDto entityToDto(Album entity) {
        AlbumDto albumDto = new AlbumDto(entity.getTitulo(), entity.getDescricao());
        albumDto.fotosBase64 = getListFotosDto(entity.getFotos());
        return albumDto;
    }

    private List<Foto> getListFotos(List<String> fotosDto, Album album){
        if(fotosDto != null){
            return fotosDto.stream().map(foto -> new Foto(foto, album)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<String> getListFotosDto(List<Foto> fotos){
        if(fotos != null) {
            return fotos.stream().map(Foto::getFotoBase64).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
