package com.erik5594.blog.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author erik_
 * Data Criacao: 06/08/2021 - 10:49
 */

@ApiModel("ComentárioResponse")
public class ComentarioResponseDto extends ComentarioDto{

    @ApiModelProperty(example = "01/12/1999", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    public Date data;

    public ComentarioResponseDto() {
    }

    public ComentarioResponseDto(String conteudo, Long idPost) {
        super(conteudo, idPost);
    }
}
