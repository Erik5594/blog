package com.erik5594.blog.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 11:20
 */

@ApiModel("Usuário")
public class UsuarioDto {

    @ApiModelProperty(required = true)
    public String nome;

    @ApiModelProperty(required = true)
    public String email;

    @ApiModelProperty(required = true)
    public String senha;

    public UsuarioDto() {
    }

    public UsuarioDto(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}