package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class AlbumNaoEncontradoException extends ValidacaoException{
    public AlbumNaoEncontradoException(long id) {
        super(String.format("Não foi encontrado um álbum com o id '%s'.", id), 404);
    }
}
