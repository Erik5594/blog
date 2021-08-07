package com.erik5594.blog.domain.exceptions;

/**
 * @author erik_
 * Data Criacao: 31/07/2021 - 15:04
 */
public class SemPermissaoExcluirAlbumException extends ValidacaoException{
    public SemPermissaoExcluirAlbumException() {
        super("Apenas o usuário que criou o álbum tem permissão para excluí-lo.", 400);
    }
}
