package com.erik5594.blog.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 20:48
 */
@ApiModel("Álbum")
public class AlbumDto {
    @ApiModelProperty(required = true)
    public String titulo;
    public String descricao;
    public List<String> fotosBase64;

    public AlbumDto() {
    }

    public AlbumDto(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}
