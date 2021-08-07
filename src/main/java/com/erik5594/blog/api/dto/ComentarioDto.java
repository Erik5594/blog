package com.erik5594.blog.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 10:49
 */

@ApiModel("Comentário")
public class ComentarioDto {

    @ApiModelProperty(required = true)
    public String conteudo;
    @ApiModelProperty(required = true)
    public Long idPost;

    public ComentarioDto() {
    }

    public ComentarioDto(String conteudo, Long idPost) {
        this.conteudo = conteudo;
        this.idPost = idPost;
    }
}
