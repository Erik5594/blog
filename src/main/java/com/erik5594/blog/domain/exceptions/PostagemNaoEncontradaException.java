package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class PostagemNaoEncontradaException extends ValidacaoException{
    public PostagemNaoEncontradaException(long id) {
        super(String.format("Não foi encontrado a postagem com o id '%s'.", id), 404);
    }
}
