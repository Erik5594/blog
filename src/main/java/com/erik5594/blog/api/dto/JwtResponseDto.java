package com.erik5594.blog.api.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 12:28
 */
@ApiModel("Login Response")
public class JwtResponseDto implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponseDto(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }


}
