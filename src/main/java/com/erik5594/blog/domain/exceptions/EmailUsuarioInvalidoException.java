package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class EmailUsuarioInvalidoException extends ValidacaoException{
    public EmailUsuarioInvalidoException(String email) {
        super(String.format("Email '%s' informado é inválido.", email), 400);
    }
}
