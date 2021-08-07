package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class ComentarioNaoEncontradoException extends ValidacaoException{
    public ComentarioNaoEncontradoException(long id) {
        super(String.format("Não foi encontrado o comentário com o id '%s'.", id), 404);
    }
}
