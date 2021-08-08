package com.erik5594.blog.api.assembler.impl;

import com.erik5594.blog.api.assembler.Assembler;
import com.erik5594.blog.api.dto.AlbumDto;
import com.erik5594.blog.domain.entity.Album;
import com.erik5594.blog.domain.entity.Foto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author erik_
 * Data Criacao: 08/08/2021 - 08:49
 */
public class AlbumAssemblerImplTeste {

    private Assembler assembler;

    @Before
    public void before(){
        assembler = new AlbumAssemblerImpl();
    }

    @Test
    public void testeAlbumDtoParaEntity(){
        //cenario
        AlbumDto albumDto = new AlbumDto("Teste 1", "Teste descricao");
        List<String> fotos = Arrays.asList("Dasfdasfd","dajkshgdalçsiheiuqw","daskhfkdnasçlkkfgaçhugh");
        albumDto.fotosBase64 = fotos;

        //ação
        Album album = (Album) assembler.dtoToEntity(albumDto);

        //verificação
        Assert.assertEquals(albumDto.titulo, album.getTitulo());
        Assert.assertEquals(albumDto.descricao, album.getDescricao());
        Assert.assertEquals(albumDto.fotosBase64.size(), album.getFotos().size());
        for(int x = 0; x < albumDto.fotosBase64.size();x++){
            Assert.assertEquals(albumDto.fotosBase64.get(x), album.getFotos().get(x).getFotoBase64());
        }
    }

    @Test
    public void testeAlbumEntityParaDto(){
        //cenario
        Album album = new Album("Teste 1", "Teste descricao");
        List<Foto> fotos = Arrays.asList(new Foto("fjdasfjdha", album), new Foto("iuiasfndasbjhr", album));
        album.setFotos(fotos);

        //ação
        AlbumDto albumDto = (AlbumDto) assembler.entityToDto(album);

        //verificação
        Assert.assertEquals(album.getTitulo(), albumDto.titulo);
        Assert.assertEquals(album.getDescricao(), albumDto.descricao);
        Assert.assertEquals(album.getFotos().size(), albumDto.fotosBase64.size());
        for(int x = 0; x < album.getFotos().size();x++){
            Assert.assertEquals(album.getFotos().get(x).getFotoBase64(), albumDto.fotosBase64.get(x));
        }
    }

    @Test
    public void testeAlbumDtoParaEntityFotosNull(){
        //cenario
        AlbumDto albumDto = new AlbumDto("Teste 1", "Teste descricao");

        //ação
        Album album = (Album) assembler.dtoToEntity(albumDto);

        //verificação
        Assert.assertEquals(albumDto.titulo, album.getTitulo());
        Assert.assertEquals(albumDto.descricao, album.getDescricao());
        Assert.assertEquals(0, album.getFotos().size());
    }

    @Test
    public void testeAlbumEntityParaDtoFotosNull(){
        //cenario
        Album album = new Album("Teste 1", "Teste descricao");

        //ação
        AlbumDto albumDto = (AlbumDto) assembler.entityToDto(album);

        //verificação
        Assert.assertEquals(album.getTitulo(), albumDto.titulo);
        Assert.assertEquals(album.getDescricao(), albumDto.descricao);
        Assert.assertEquals(0, albumDto.fotosBase64.size());
    }

}
